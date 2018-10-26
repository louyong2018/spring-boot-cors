package springboot.framework.demo.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

	@Test
	public void contextLoads() {
		String J = "aA";
		String S = "aAAdsf";
		int num = 0;
		for(int i=0;i<S.length();i++){
			if(J.contains(S.subSequence(i,i+1))){
				System.out.println(S.charAt(i));
				num++;
			}
		}
		System.out.println(num);
	}

}
