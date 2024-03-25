package com.presnakou.regex.thread;

import java.util.Optional;
import java.util.Queue;

public class ComplaintReader extends Thread{

    private final Queue<Runnable> complaints;

    public ComplaintReader(Queue<Runnable> complaints) {
        this.complaints = complaints;
    }

    @Override
    public void run() {
        while (true) {
            Optional<Runnable> complaint = Optional.empty();
            synchronized (complaints) {
                if (!complaints.isEmpty()) {
                    complaint = Optional.of(complaints.remove());
                }
            }
            complaint.ifPresent(Runnable::run);
        }
    }
}
