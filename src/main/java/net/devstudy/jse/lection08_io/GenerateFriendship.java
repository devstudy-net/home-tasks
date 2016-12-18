package net.devstudy.jse.lection08_io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class GenerateFriendship {

	public static void main(String[] args) throws IOException {
		int minFriends = 4;
		int maxFriends = 16;

		List<String> accounts = Files.readAllLines(Paths.get("male-accounts.txt"), StandardCharsets.UTF_8);
		accounts.addAll(Files.readAllLines(Paths.get("female-accounts.txt"), StandardCharsets.UTF_8));

		Map<String, Integer> friendsCount = new HashMap<>();
		Map<String, Account> accountsMap = new HashMap<>();
		// Генерируем случайное количество друзей для каждого аккаунта
		populateMaps(friendsCount, accountsMap, accounts, minFriends, maxFriends);
		// Создание друзей, в соответствии с сгенерированым количеством
		// friendsCount
		createFriendship(accounts, friendsCount, accountsMap);
		// Запись дружбы в требуемом формате
		writeFriends(accountsMap);
	}
	
	private static void populateMaps(Map<String, Integer> friendsCount, Map<String, Account> accountsMap, List<String> accounts, int minFriends, int maxFriends) {
		Random r = new Random();
		for (String account : accounts) {
			friendsCount.put(account, (r.nextInt((maxFriends + 1) / 2 - minFriends) + minFriends));
			accountsMap.put(account, new Account(account));
		}
	}
	
	private static void createFriendship(List<String> accounts, Map<String, Integer> friendsCount, Map<String, Account> accountsMap) {
		Random r = new Random();
		for (Map.Entry<String, Integer> friend : friendsCount.entrySet()) {
			String name = friend.getKey();
			Account account = accountsMap.get(name);
			// Пока друзей меньше чем необходимо
			while (account.getFriends().size() < friend.getValue()) {
				String friendName = accounts.get(r.nextInt(accounts.size()));
				// Исключаем появления проблемы "сам себе друг"
				if (!friendName.equals(account)) {
					Account friendAccount = accountsMap.get(friendName);
					// Дружба должна быть двунаправленной, если А - друг Б,
					// то и Б должен быть другом А
					account.addFriend(friendAccount);
					friendAccount.addFriend(account);
				}
			}
		}
	}
	
	private static void writeFriends(Map<String, Account> accountsMap) throws IOException{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		try (PrintWriter pw = new PrintWriter(new File("friends.txt"))) {
			for (Account account : accountsMap.values()) {
				pw.println(account + ":");
				pw.println("->" + account.getFriends());
				if (min > account.getFriends().size()) {
					min = account.getFriends().size();
				}
				if (max < account.getFriends().size()) {
					max = account.getFriends().size();
				}
			}
		}
		System.out.println("Min friends=" + min + ", max friends=" + max);
	}

	/**
	 * 
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	private static class Account {
		private final String name;
		private final Set<Account> friends = new HashSet<>();

		public Account(String name) {
			super();
			this.name = name;
		}

		public Set<Account> getFriends() {
			return friends;
		}

		public void addFriend(Account account) {
			friends.add(account);
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Account other = (Account) obj;
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			return true;
		}
	}
}
