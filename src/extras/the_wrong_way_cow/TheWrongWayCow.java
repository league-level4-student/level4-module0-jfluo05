//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {

		int counter = 0;
		int counter2 = 0;
		int counter3 = 0;
		int counter4 = 0;

		int row = 0;
		int column = 0;

		int row2 = 0;
		int column2 = 0;
		
		int row3 = 0;
		int column3 = 0;
		
		int row4 = 0;
		int column4 = 0;

		// Fill in the code to return the x,y coordinate position of the
		// head (letter 'c') of the wrong way cow!
		for (int i = 0; i < field.length; i++) {
			for (int k = 0; k < field[i].length; k++) {
			if(field[i][k]=='c') {
				System.out.println(i+" "+k);
			}
				if (k+2<field[i].length && field[i][k] == 'c') {
					if (field[i][k + 1] == 'o') {
						if ( field[i][k + 2] == 'w') {
							counter = counter + 1;
							row = i;
							column = k;
						}
					}
				}
				if (k-2>=0 && field[i][k] == 'c') {
					if (field[i][k - 1] == 'o') {
						if ( field[i][k - 2] == 'w') {
							counter3 = counter3 + 1;
							row3 = i;
							column3 = k;
						}
					}
				}
				if (i+2<field.length &&field[i][k] == 'c') {
					if (field[i + 1][k] == 'o') {
						if (field[i + 2][k] == 'w') {
							counter2 = counter2 + 1;
							row2 = i;
							column2 = k;
						}
					}
				}
				if (i-2>=0 &&field[i][k] == 'c') {
					if (field[i - 1][k] == 'o') {
						if (field[i - 2][k] == 'w') {
							counter4 = counter4+ 1;
							row4 = i;
							column4 = k;
						}
					}
				}
			}
		} if(counter==1){
			int[] coordinates = { column,row};
		
			return coordinates;
		}
		else if (counter2 == 1) {
			int[] coordinates2 = { column2,row2};
		
			return coordinates2;
		} else if(counter3==1){
			int[] coordinates3 = { column3,row3};
			
			return coordinates3;
		}else {
			int[] coordinates4 = { column4,row4};
		
			return coordinates4;
		}

	}
}