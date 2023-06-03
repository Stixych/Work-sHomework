import org.junit.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BtaPortalTests {
    public static void main(String[] args) {
	@Test
        // 1. Atvērt BTA portālu (www.bta.lv)
        Selenide.open("https://www.bta.lv");

        // 2. Pārvietoties uz ceļojuma polišu iegādes formu
        Selenide.$("#ceļojuma_polišu_iegādes_forma").click();

        // 3. Nomainīt ceļojumā mērķi uz Indija izmantojot “Izvēlies valstis”
        Selenide.$("#izvēlies_valstis").selectOption("Indija");

        // 4. Pārbaudīt vai ceļojuma mērķis ir nomainīts
        Selenide.$("#ceļojuma_mērķis").shouldHave(Condition.value("Indija"));

        // 5. Nomainīt aktivitāti uz “Sports”
        Selenide.$("#aktivitāte").selectOption("Sports");

        // 6. Pārbaudīt vai aktivitāte nomainīta
        Selenide.$("#aktivitāte").shouldHave(Condition.value("Sports"));

        // 7. Pārvietoties uz otro soli
        Selenide.$("#nākamais_solis").click();

        // 8. Izvēlēties Optimal+
        Selenide.$("#izvēlies_plānu").selectOption("Optimal+");

        // 9. Atvērt ”Apskati, kas ir apdrošināts” izvēlētajai programmai
        Selenide.$("#apskati_kas_ir_apdrošināts").click();

        // 10. Pārbaudīt vai uzlecošā forma ir atvērusies
        Selenide.$("#uzlecošā_forma").shouldBe(Condition.visible);

        // 11. Aizvērt un pārvietoties uz nākamo soli
        Selenide.$("#aizvērt").click();
        Selenide.$("#nākamais_solis").click();

        // 12. Pārbaudīt vai ceļotāja lauki ir redzami un tie ir tukši
        Selenide.$("#ceļotājs").shouldBe(Condition.visible)
                .$("input").shouldHave(Condition.value(""));
    }
}