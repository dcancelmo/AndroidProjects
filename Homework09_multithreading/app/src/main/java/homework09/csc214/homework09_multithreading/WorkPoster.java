package homework09.csc214.homework09_multithreading;

/**
 * Created by Dan on 4/25/17.
 */

public class WorkPoster<W> implements Runnable {
    private final W mWork;
    private final JobListener<W> mListener;

    public WorkPoster(W work, JobListener<W> listener) {
        mWork = work;
        mListener = listener;
    }

    @Override
    public void run() {
        mListener.someWorkCompleted(mWork);
    }
}
