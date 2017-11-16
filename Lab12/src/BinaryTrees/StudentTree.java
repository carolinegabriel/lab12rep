package BinaryTrees;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StudentTree {

	public BinarySearchTree readFile() {
		File inputFile = new File("students.in");
		BinarySearchTree bst = new BinarySearchTree();

		try {
			Scanner reader = new Scanner(inputFile);

			int id;
			String name;
			double gpa;
			String advisor;

			String line;
			while (reader.hasNextLine()) {

				line = reader.nextLine();

				String[] splitted = line.split(" ");

				id = Integer.parseInt(splitted[0]);
				name = splitted[1];
				gpa = Double.parseDouble(splitted[2]);

				StudentGPA stu;
				if (splitted.length > 3) {
					advisor = splitted[3];
					stu = new GraduateStudentGPA(id, name, gpa, advisor);
				} else {
					stu = new StudentGPA(id, name, gpa);
				}

				bst.insert(stu);

			}

			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return bst;
	}

	public void printStudents(BinarySearchTree bst) {
		TreeIterator iter = new TreeIterator(bst);
		
		iter.printInorder();

	}

	public static void main(String args[]) {
		StudentTree st = new StudentTree();
		BinarySearchTree bst = st.readFile();
		st.printStudents(bst);

	}
}