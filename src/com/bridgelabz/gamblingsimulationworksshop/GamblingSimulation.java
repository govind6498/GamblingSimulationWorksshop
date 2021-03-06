package com.bridgelabz.gamblingsimulationworksshop;
import java.util.*;
public class GamblingSimulation {
	public static final int STAKES_EVERYDAY = 100;
	public static final int STAKES_EVERYGAME = 1;
	public static final int WIN = 1;
	public static final int LOSE = 0;
	public static final int TOTAL_DAYS = 20;

	public static final int MIN = (STAKES_EVERYDAY) - (50*STAKES_EVERYDAY/100);
	public static final int MAX = (STAKES_EVERYDAY) + (50*STAKES_EVERYDAY/100);

	public static int countLose=0;
	public static int countWin=0;

	public static ArrayList<Integer> daysWon=new ArrayList<Integer>();
	public static ArrayList<Integer> daysLost=new ArrayList<Integer>();

	public static int everyGameBetOutcome(int cash) {
		int gameState = (int)Math.floor(Math.random()*10)%2;
		if(gameState == WIN) {
			cash++;
		}
		else if(gameState == LOSE) {
			cash--;
		}
		return cash;
	}

	public static int calculativeGambler(int netCash) {
		int min = (STAKES_EVERYDAY) - (50*STAKES_EVERYDAY/100);
		int max = (STAKES_EVERYDAY) + (50*STAKES_EVERYDAY/100);
		while (netCash >  min && netCash < max)
			public static int calculativeGambler(int netCash, int day) {
			while (netCash >  MIN && netCash < MAX)
			{
				netCash = everyGameBetOutcome(netCash);
			}
			if(netCash == max) {
				countWin++;
			}
			else if(netCash == min) {
				if(netCash == MIN) {
					countLose++;
					daysLost.add(day);
				}
				else if(netCash == MAX) {
					countWin++;
					daysWon.add(day);
				}
				return netCash;
			}
			public static int everyMonthBetOutcome(int cash) {
				int netCash=0;
				for(int days=1; days <= TOTAL_DAYS; days++) {
					cash = STAKES_EVERYDAY;
					netCash+=calculativeGambler(cash);
					netCash+=calculativeGambler(cash,days);
				}
				return netCash;
			}


			public static void loseOrWinCounter() {
				System.out.println("Days Won: "+countWin);
				System.out.println("Days Lost: "+countLose);
				if(countWin > countLose){
					System.out.println("Won by "+(countWin-countLose)+" Days");
				}
				else if(countLose > countWin){
					System.out.println("Lost by "+(countLose-countWin)+" Days");
				}
				else {
					System.out.println("Draw Game");
				}
			}


			public static void luckyOrUnluckyDay () {
				System.out.println("Lucky Days: "+daysWon);
				System.out.println("Unlucky Days: "+daysLost);
			}

			public static void main(String[] args) {
				int netCash = STAKES_EVERYDAY;
				netCash = everyMonthBetOutcome(netCash);
				System.out.println(netCash);
				loseOrWinCounter();
				luckyOrUnluckyDay();
			}
			
		}	
	}
