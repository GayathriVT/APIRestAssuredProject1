package RestAssured.VerifyResponse;

import org.testng.annotations.Test;

import java.io.File;
import static org.assertj.core.api.Assertions.*;

public class AsserjforFileReading {
    @Test
    public void fileRead()
    {
        File file = new File("C:\\Users\\Anoop Sinha\\IdeaProjects\\APIRest1\\MOCK_DATA");
       assertThat(file).canRead().isNotNull().isFile().exists();
    }
}
