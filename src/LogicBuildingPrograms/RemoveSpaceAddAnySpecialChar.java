package LogicBuildingPrograms;

public class RemoveSpaceAddAnySpecialChar {

    public static void main(String[] args) {
        String str = "  nav  in";
        str = str.replaceAll("\\s","");
        System.out.println(str);

        String str2 = "  nav  in";
        str2 = str2.replaceAll("\\s","%20");
        System.out.println(str2);
    }
}
