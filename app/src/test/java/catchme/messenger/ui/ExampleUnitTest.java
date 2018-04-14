package catchme.messenger.ui;

import org.junit.Before;
import org.junit.Test;

import org.catchme.net.API;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    API api;


    @Before
    public void api_get_token_test() throws Exception {
        api = new API("dima", "qwerty");
        System.out.println(api.getToken());
    }

    @Test
    public void get_sync_chat_list_test() throws Exception {
        System.out.println(api.getChatList());
    }
}