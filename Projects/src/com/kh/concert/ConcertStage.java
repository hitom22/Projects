package com.kh.concert;

import java.util.Random;
import java.util.Scanner;

public class ConcertStage {
	private Scanner sc;
	private static String[][] seats;
	private static int inputRowsInt;
	private static int inputNum2;
	private static String inputRows;
	private static int reservationSeats;
	
	static {
		inputRows ="";
		inputRowsInt = 0;
		inputNum2 = 0;
		seats = new String[][] {
			{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
			{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
			{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
			{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
			{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
			{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}
    };
		reservationSeats =0;
	}
	
	public ConcertStage() {
		sc = new Scanner(System.in);
	} //생성자 종료

	private void seatsStatus(String[][] array) {
		int sum=0;
		for(int i=0; i<array.length; i++) {
			sum += array[i].length;
		}
		System.out.print("(전체좌석: " + sum+" / 예약가능 좌석: "+ (sum-reservationSeats) +")\n" );
	}
	
	private void resetSeats() {
		if(reservationSeats==0) {
			System.out.println("\n\n 예약된 좌석이 없습니다.");
			return;
		}else {
			for(int i=0; i<seats.length; i++) {
				for(int j=0; j<seats[i].length; j++) {
					seats[i][j] = String.valueOf(j+1);
				}
			}
			reservationSeats = 0;
			System.out.println("\n\n 예매를 모두 취소하였습니다.");
		}
	}
	
	public void showMenu() {
		do {
			try {
				String texth1 = "\n\n========== 콘서트 예매 프로그램 ==========\n\n";
				System.out.println(texth1);
				System.out.println("1. 좌석 확인");
				System.out.print("2. 좌석 예매");
				seatsStatus(seats);
				System.out.println("3. 예매 취소하기");
				System.out.println("4. 예매 일괄 취소하기");
				System.out.println("5. 프로그램 종료");
				System.out.print("\n메뉴 선택 : ");
				int menu = Integer.parseInt(sc.nextLine());
				System.out.println();
				for(int i=0; i<texth1.length(); i++) {
					System.out.print("=");
				} System.out.println();
				
				switch(menu) {
				case 1 :
					showSeats();
					break;
				case 2 :
					inputSeat(menu);
					break;
				case 3 : 
					inputSeat(menu);
					break;
				case 4 :
					resetSeats();
					break;
				case 5 :
					return;
				default :
					System.out.println("\n\n @@@ 올바른 메뉴를 선택하세요. @@@\n\n");
				}
			}catch(Exception e) {
				System.out.println("\n\n @@@ 올바른 메뉴를 선택하세요. @@@\n\n");
			}
			
		}while(true);
	}
	
	private void showSeats() {
		System.out.println("\n               STAGE(무대)");
		System.out.println();
		for(int i=0; i<seats.length; i++) {
			for (int j=65+i;j<66+i;j++) {
				System.out.print((char)j);
			}
			System.out.print("|");
			System.out.print(" ");
			for(int j=0; j < seats[i].length; j++) {
				System.out.print(" ");
				System.out.print(seats[i][j]);
			} 
			System.out.println();
			for(int k=0; k< seats[i].length+25; k++) {
				System.out.print("-");
			}
			System.out.println();	
		}
		
	}

	private void changeSeats() {
		if(seats[inputRowsInt][inputNum2-1].equals(" ")) {
			System.out.println("\n [다시 확인하세요!] 이미 예약된 좌석 입니다.");
		} else {
			seats[inputRowsInt][inputNum2-1] = " ";
			System.out.println("\n@@@@@@@@ 좌석을 예약했습니다 @@@@@@@@\n");
			reservationSeats++;
		}
	}
	
	private void cancelSeats() {
		if(seats[inputRowsInt][inputNum2-1].equals(" ")) {
			seats[inputRowsInt][inputNum2-1] = String.valueOf(inputNum2);
			System.out.println("\n@@@@@@@@ 좌석예약을 취소했습니다 @@@@@@@@\n");
			reservationSeats--;
		} else {
			System.out.println("\n [다시 확인하세요!] 예약된 좌석이 아닙니다.");
		}
	}
	
	private void displayMenu() throws InterruptedException {
		System.out.println("\\n               STAGE(무대)");
		System.out.println();
		for(int i=0; i<seats.length; i++) {
			for (int j=65+i;j<66+i;j++) {
				System.out.print((char)j);
			}
			System.out.print("|");
			System.out.print(" ");
			for(int j=0; j < seats[i].length; j++) {
				System.out.print(" ");
				System.out.print(seats[i][j]);
			} 
			System.out.println();
			for(int k=0; k< seats[i].length+8; k++) {
				System.out.print("-");
			}
			System.out.println();	
		}
		System.out.println();
//		System.out.println("(\"X\"는 이미 예약된 좌석입니다.)");
		System.out.print("\n행을 선택하세요.(A~G)\n==> ");
		inputRows = sc.nextLine();
		System.out.print("열을 선택하세요.(1~15)\n==> ");
		inputNum2 = Integer.parseInt(sc.nextLine());
	}
	
	private void inputSeat(int menu) {
			try {
				if(reservationSeats==0 && menu==3) {
					System.out.println("\n\n @@@ 예약된 좌석이 없습니다.@@@");
					return;
				}
				displayMenu();
				switch(inputRows.toLowerCase()) {
				case "A":
				case "a":
					inputRowsInt = 0;
					if(menu==2) {
						changeSeats();
						break;
					} else if(menu==3) {
						cancelSeats();
						break;
					}
				case "B": 
				case "b":
					inputRowsInt = 1; 
					if(menu==2) {
						changeSeats();
						break;
					} else if(menu==3) {
						cancelSeats();
						break;
					}
				case "C":
				case "c":
					inputRowsInt = 2; 
					if(menu==2) {
						changeSeats();
						break;
					} else if(menu==3) {
						cancelSeats();
						break;
					}
				case "D":
				case "d":
					inputRowsInt = 3; 
					if(menu==2) {
						changeSeats();
						break;
					} else if(menu==3) {
						cancelSeats();
						break;
					}
				case "E":
				case "e":
					inputRowsInt = 4;
					if (menu==2) {
						changeSeats();
						break;
					}else if(menu==3) {
						cancelSeats();
						break;
					}
				case "F":
				case "f":
					inputRowsInt = 5;
					if (menu==2) {
						changeSeats();
						break;
					}else if(menu==3) {
						cancelSeats();
						break;
					}
				case "G":
				case "g":
					inputRowsInt = 6;
					if (menu==2) {
						changeSeats();
						break;
					}else if(menu==3) {
						cancelSeats();
						break;
					}
				default:
					System.out.println("\n\n올바른 좌석을 선택해주십시오\n\n");
				}
			} catch (Exception e) {
				System.out.println("\n\n올바른 좌석을 선택해주십시오\n\n");
			}
	}
}