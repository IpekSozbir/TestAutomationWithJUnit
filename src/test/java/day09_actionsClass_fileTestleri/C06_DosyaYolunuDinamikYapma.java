package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYolunuDinamikYapma {

    @Test
    public void test01 () {

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String downloadsDenemeDosyaYolu = "/Users/ipeksozbir/Downloads/deneme.txt";
        Assertions.assertTrue(Files.exists(Paths.get(downloadsDenemeDosyaYolu)));


        /*
        eger dosya yolunu normal olarak yazarsak (/Users/muratsozbir/Downloads/deneme.txt)
        sadece dosya yolunu olusturan kisinin bilgisayarinda calisir
        baska bilgisayarlarda calismaz

        Java ortak calisabilmemiz icin
        her kisinin bilgisayarinda farkli olan bastaki kismi alabilecegimiz bir kod hazirlamistir

        herkeste farkli olan kisim (/Users/ipeksozbir),
        herkeste ortak olan kisim (/Downloads/deneme.txt)
         */


        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin
        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/deneme.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


        // day09 package'i altinda deneme.txt dosyaisinin var oldugunu test edin
        String denemeDosyaYolu = "src/test/java/day09_actionsClass_fileTestleri/deneme.txt";
        System.out.println(Files.exists(Paths.get(denemeDosyaYolu))); // true

        /*
        /Users/ipeksozbir/IdeaProjects/Team148_JUnit/src/test/java/day09_actionsClass_fileTestleri/deneme.txt
         */

        System.out.println(System.getProperty("user.dir"));
        // herkeste farkli olan kisim ==>   /Users/ipeksozbir/IdeaProjects/Team148_JUnit
        // herkeste ayni olan kisim ==>   /src/test/java/day09_actionsClass_fileTestleri/deneme.txt

        String dinamikProjeDosyaYolu = System.getProperty("user.dir");
        dinamikDosyaYolu = dinamikProjeDosyaYolu + "/src/test/java/day09_actionsClass_fileTestleri/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }

}
