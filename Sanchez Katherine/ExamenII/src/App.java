import SKDAC.SKDTO.SKHormigueroDTO;
import SKDAC.SKHormigueroDAO;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            SKHormigueroDAO SKHormigueroDao = new SKHormigueroDAO();
            for (SKHormigueroDTO s : SKHormigueroDao.readALL())
                System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
