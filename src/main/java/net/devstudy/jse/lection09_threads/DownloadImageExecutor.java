package net.devstudy.jse.lection09_threads;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class DownloadImageExecutor {

	private int threadCount;
	private int tryCount;
	private Path targetDir;
	
	public DownloadImageExecutor(int threadCount, int tryCount, Path targetDir) {
		super();
		this.threadCount = threadCount;
		this.tryCount = tryCount;
		this.targetDir = targetDir;
	}

	public void launch() throws IOException{
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
		List<String> links = Files.readAllLines(Paths.get("files/links/images.txt"), StandardCharsets.UTF_8);
		for(String link : links) {
			executorService.submit(new DownloadTask(link, targetDir, executorService, tryCount));
		}
		//Остановить сервис после выполнения всех задач
		executorService.shutdown();
	}

	/**
	 * 
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	private static class DownloadTask implements Runnable {
		private final String link;
		private final Path targetDir;
		private final ExecutorService executorService;
		private int tryCount;

		public DownloadTask(String link, Path targetDir, ExecutorService executorService, int tryCount) {
			super();
			this.link = link;
			this.targetDir = targetDir;
			this.executorService = executorService;
			this.tryCount = tryCount;
		}

		@Override
		public void run() {
			//Генерируем уникальное имя файла
			String fileName = UUID.randomUUID().toString() + ".jpg";
			try (InputStream in = new URL(link).openStream()) {
				Files.copy(in, Paths.get(new File(targetDir.toFile(), fileName).getAbsolutePath()));
				System.out.println("Link downloaded: "+link);
			} catch (IOException e) {
				e.printStackTrace();
				tryCount--;
				if (tryCount > 0) {
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e1) {
						return;
					}
					// Повторная попытка скачивания файла после 10 секундного перерыва
					executorService.submit(this);
				} else {
					System.err.println("Image not downloaded: " + link);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// Запуск скачивания в 10 потоков, в папку files/target с неудачными попытками равными 3
		DownloadImageExecutor e = new DownloadImageExecutor(10, 3, Paths.get("files/target"));
		e.launch();
	}
}
