package day11_webTables_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01 () throws IOException {
        // Excel'deki bilgileri kullanabilmek icin
        // once excel'deki datalara ulasmamiz lazim
        // bilgisayarimizdaki dosyaya selenium WebDriver ile ulasamayacagimiz icin
        // java'dan yardim istemeliyiz

        // 1. adim dosya yolunu alalim
        String dosyaYolu = "src/test/java/day11_webTables_ExcelOtomasyon/ulkeler.xlsx";

        // 2. adim Java ile dosyaya erismek icin
        FileInputStream  fileInputStream = new FileInputStream(dosyaYolu);

        // 3. adim excel'den alinan bilgileri
        // kodlarimizin icinde olusturacagimiz bir obje olarak kaydedelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);

            // Artik fiziki excel dosyasindaki tum bilgileri
            // kodlarimiz icerisinde olusturdugumuz workbook objesine kaydettik

        // 4. adim excel'in kopyasi olan workbook'ta istedigimiz bilgiye ulasalim
        //Sayfa1'deki 5. satir, 3. hucredeki bilgiyi yazdirin

        // workbook da javadaki genel kabula uygun olarak
        // index kullanilir
        // index 0'dan basladigi icin
        // 5. satir icin index = 4, 3. sutun inic index= 2

        Sheet sheet1 = workbook.getSheet("Sayfa1");
        Row row = sheet1.getRow(4);
        Cell cell = row.getCell(2);
        System.out.println("Sayfa1 5.satir 3.sutun: " + cell);

        // her seferinde row ve cell olusturmaya gerek yok
        // sayfa1'deki 15.satir 2. sutundaki bilgiyi yazdirin

        System.out.println(workbook.getSheet("Sayfa1").getRow(14).getCell(1));

        // son satir numarasini yazdirin
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()+1);

        // kullanilan satir sayisini yazdirin
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());
    }
}
