package InterviewCode;

public class printDuplicateValueFormArray {
	public static void integer() {
		int a[] = { 1, 2, 3, 2, 1, 4, 5, 4, 7, 6, 6, 7, 5 };

		for (int i = 0; i < a.length; i++) {
			int cnt = 0;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					cnt++;
				}
			}
			for (int k = i; k < a.length; k++) {
				if (a[i] == a[k]) {
					break;
				}
			}
			if (cnt > 0) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.println();
	}


	public void string() {
		String s1 = "abbcddaefggh";

		char[] ch = s1.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			int cnt = 0;
			for (int j = i+1; j < ch.length; j++) {
				if(ch[i] == ch[j])
				{
					cnt++;
				}
			}
			for (int k = i; k < ch.length; k++) {
				if(ch[i] == ch[k])
				{
					break;
				}
			}
			if(cnt > 0)
			{
				System.out.print(ch[i]+" ");
			}
		}
	}

	public static void main(String[] args) {
		integer();
		printDuplicateValueFormArray obj = new printDuplicateValueFormArray();
		obj.string();
	}
}
