package board_main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board_dto.article;

public class app {
	private static List<article> articles;
	app() {
		articles = new ArrayList<>();
	}

		public void start() {
		System.out.println(" == ���α׷� ���� == ");
		maketestdate();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("��ɾ� : ");
			String command = sc.nextLine();
			command.trim();
			if (command.length() == 0) {
				continue;
			}
			if (command.equals("list")) {
				if (articles.size() == 0) {
					System.out.println("�Խù��� �������� �ʽ��ϴ�.\n");
					continue;
				}
				String searchkeyword = command.substring("list".length()).trim();
				List<article> forListarticle = articles;
				if(searchkeyword.length()>0) {
					forListarticle = new ArrayList<>();
					for(article article : articles) {
						if(article.title.contains(searchkeyword)) {
							forListarticle.add(article);
						}
					}
					if(forListarticle.size() == 0) {
						System.out.println("�˻� ����� �������� �ʽ��ϴ�.\n");
					}
				}
				
				System.out.println(" == �Խù� ��� == ");
				for(int i = articles.size()-1 ; i >= 0; i -- ) {
					article currentarticle  = articles.get(i);
				System.out.printf("%d   |   %s   |   %s   |  %s  |  %d  |\n", currentarticle.id,
							currentarticle.title, currentarticle.body, currentarticle.regDate, currentarticle.hit);
				}

			} else if (command.equals("write")) {
				int id = articles.size()+1;
				System.out.println("���� : ");
				String title = sc.nextLine();
				System.out.println("���� : ");
				String body = sc.nextLine();
				String currentdate = utile.getcurrentdate();
				article article = new article(id, title, body, currentdate);
				articles.add(article);
			} else if (command.startsWith("article detail ")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				article targetarticle = getarticlebyid(id);
				if (targetarticle == null) {
					System.out.printf("%d�� �Խù��� �������� �ʽ��ϴ�.\n", id);
					continue;
				}
				targetarticle.increasehit();
				System.out.printf("���� : %s\n", targetarticle.title);
				System.out.printf("���� : %s\n", targetarticle.body);
				System.out.printf("�ۼ��� : %s\n", targetarticle.regDate);
				System.out.printf("��ȸ�� : %d\n", targetarticle.hit);
			} else if (command.startsWith("article modify")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				article targetarticle = getarticlebyid(id); 
				if (targetarticle == null) {
					System.out.printf("%d���� �Խù��� �������� �ʽ��ϴ�.\n", id);
					continue;
				}
				System.out.println("���� : ");
				String title = sc.nextLine();
				System.out.println("���� : ");
				String body = sc.nextLine();
				targetarticle.title = title;
				targetarticle.body = body;
				System.out.printf("%d�� �Խù��� ����Ǿ����ϴ�.\n", id);
			} else if (command.startsWith("article delete")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				int foundindex = getarticleindexbyid(id);
				if (foundindex == -1) {
					System.out.printf("%d���� �Խù��� �������� �ʽ��ϴ�.\n", id);
					continue;
				}
				articles.remove(foundindex);
				System.out.printf("%d�� �Խù��� �����Ǿ����ϴ�.\n", id);
			} else {
				System.out.printf("%s�� ���� ��ɾ��Դϴ�.\n", command);
			}
		}
	}

	private int getarticleindexbyid(int id) {
		int i = 0;
		for(article article : articles) {
			if(article.id == id) {
				return i;
			}
			i ++;
		}
		return -1;
	}
	private article getarticlebyid(int id) {
		int index = getarticleindexbyid(id);
		if(index != -1) {
			return articles.get(index);
		}
		return null;
	}

	private static void maketestdate() {
		System.out.println("�׽�Ʈ�� ���� �����͸� �����մϴ�.");
		articles.add(new article(1, "����1", "����1", utile.getcurrentdate()));
		articles.add(new article(2, "����2", "����2", utile.getcurrentdate()));
		articles.add(new article(3, "����3", "����3", utile.getcurrentdate()));
	}


}
