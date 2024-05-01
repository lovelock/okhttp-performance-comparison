package fun.happyhacker.okhttpmultithreadvsasync;

import fun.happyhacker.okhttpmultithreadvsasync.service.AsyncService;
import fun.happyhacker.okhttpmultithreadvsasync.service.MultiThreadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OkhttpMultithreadVsAsyncApplicationTests {

	@Autowired
	private MultiThreadService multiThreadService;
	@Autowired
	private AsyncService asyncService;

	@Test
	void testAsyncService() {
		int count = asyncService.call();
		assertEquals(100, count);
	}

	@Test
	void testMultiThreadService() {
		int count = multiThreadService.call();
		assertEquals(100, count);
	}
}
