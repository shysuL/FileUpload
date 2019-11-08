package service.test;

import java.util.UUID;

public class test1 {
	public static void main(String[] args) {
		// --- UUIP 생성 ---
		UUID uuid = UUID.randomUUID(); // 랜덤 UID 생성
		
		String u = uuid.toString();
		
		System.out.println(u);
		String[] res = u.split("-");
		
		for(String uid : res) {
			System.out.println(uid);
		}
		
		// 12자리 랜덤 UID 만들기
		System.out.println("--- 12자리 ---");
		System.out.println(res[4]);
		System.out.println(res[1] + res[2] + res[3]);
				
		// 20자리 랜덤 UID 만들기
		System.out.println("--- 20자리 ---");
		System.out.println(res[1] + res[2] + res[4]);

	
		
		
	}

}
