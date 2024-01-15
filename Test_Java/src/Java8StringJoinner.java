import java.util.StringJoiner;

public class Java8StringJoinner {
	public static void main(String[] args) {
		StringJoiner sjJoiner1 = new StringJoiner(",","[","]");
		sjJoiner1.add("A").add("B").add("C");
		StringJoiner sjJoiner2 = new StringJoiner(":");
		sjJoiner2.add("D").add("E").add("F");
		sjJoiner1.merge(sjJoiner2);
		System.out.println(sjJoiner1);
		
		
	}

}
