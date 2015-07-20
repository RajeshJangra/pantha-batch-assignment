package com.pantha.service;

import com.pantha.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * JobCompletionNotificationListener Tester.
 *
 * @author Rajesh Kumar
 * @version 1.0
 * @since <pre>Jul 20, 2015</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class JobCompletionNotificationListenerTest {

    /**
     * Method: afterJob(JobExecution jobExecution)
     */
    @Test
    public void testAfterJob() throws Exception {
        Logger logger = mock(Logger.class);
        JobCompletionNotificationListener listener = new JobCompletionNotificationListener();
        listener.log = logger;
        final JobExecution jobExecution = mock(JobExecution.class);
        when(jobExecution.getStatus()).thenReturn(BatchStatus.COMPLETED);
        listener.afterJob(jobExecution);
        verify(jobExecution).getStatus();
        verify(logger).info(anyString());
    }
}
