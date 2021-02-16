package core.event;

import java.lang.System;

/**
 * Base class to aggregate UI events of certain type.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0007\u00a2\u0006\u0002\u0010\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fR\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00018\u00008\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcore/event/UiEvents;", "T", "", "()V", "internalEvents", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "post", "", "event", "(Ljava/lang/Object;)V", "stream", "Lio/reactivex/Observable;", "core-lib_debug"})
public final class UiEvents<T extends java.lang.Object> {
    private final io.reactivex.subjects.PublishSubject<T> internalEvents = null;
    
    /**
     * Posts next UI event.
     * @param event UI event.
     */
    @androidx.annotation.UiThread()
    @androidx.annotation.MainThread()
    public final void post(@org.jetbrains.annotations.NotNull()
    T event) {
    }
    
    /**
     * Obtains all emitted events as an Observable.
     * @return Observable, that contains all emitted UI events.
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<T> stream() {
        return null;
    }
    
    public UiEvents() {
        super();
    }
}