package com.discord.restapi.utils;

import b.d.b.a.a;
import d0.g0.c;
import d0.z.d.m;
import g0.e;
import g0.i;
import g0.q;
import g0.v;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: CountingRequestBody.kt */
/* loaded from: classes.dex */
public final class CountingRequestBody extends RequestBody {
    private final BehaviorSubject<Long> bytesWrittenSubject;
    private final RequestBody delegate;
    private final long estimatedContentLength;
    private final int ignoreWriteToCount;
    private int numWriteToCalls;

    /* compiled from: CountingRequestBody.kt */
    public static final class CountingSink extends i {
        private long bytesWritten;
        private final Function1<Long, Unit> listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CountingSink(v vVar, Function1<? super Long, Unit> function1) {
            super(vVar);
            m.checkNotNullParameter(vVar, "delegate");
            m.checkNotNullParameter(function1, "listener");
            this.listener = function1;
        }

        @Override // g0.i, g0.v
        public void write(e source, long byteCount) throws IOException {
            m.checkNotNullParameter(source, "source");
            super.write(source, byteCount);
            long j = this.bytesWritten + byteCount;
            this.bytesWritten = j;
            this.listener.invoke(Long.valueOf(j));
        }
    }

    public /* synthetic */ CountingRequestBody(RequestBody requestBody, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestBody, (i2 & 2) != 0 ? 0 : i);
    }

    public static final /* synthetic */ void access$updateProgress(CountingRequestBody countingRequestBody, long j) {
        countingRequestBody.updateProgress(j);
    }

    private final void updateProgress(long bytesWritten) {
        if (this.numWriteToCalls > this.ignoreWriteToCount) {
            this.bytesWrittenSubject.onNext(Long.valueOf(bytesWritten));
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.delegate.contentType();
    }

    public final Observable<Long> getBytesWrittenObservable() {
        Observable<Long> observableL = this.bytesWrittenSubject.r().L();
        m.checkNotNullExpressionValue(observableL, "bytesWrittenSubject.dist…().onBackpressureLatest()");
        return observableL;
    }

    public final long getEstimatedContentLength() {
        return this.estimatedContentLength;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        m.checkNotNullParameter(sink, "sink");
        int i = this.numWriteToCalls;
        this.numWriteToCalls = i + 1;
        if (i < this.ignoreWriteToCount) {
            ByteString.Companion companion = ByteString.INSTANCE;
            StringBuilder sbQ = a.Q('<');
            sbQ.append(this.delegate);
            sbQ.append('>');
            sink.e0(companion.b(sbQ.toString(), c.a));
            return;
        }
        CountingSink countingSink = new CountingSink(sink, new CountingRequestBody$writeTo$countingSink$1(this));
        m.checkParameterIsNotNull(countingSink, "$this$buffer");
        q qVar = new q(countingSink);
        this.delegate.writeTo(qVar);
        qVar.flush();
    }

    public CountingRequestBody(RequestBody requestBody, int i) {
        m.checkNotNullParameter(requestBody, "delegate");
        this.delegate = requestBody;
        this.ignoreWriteToCount = i;
        this.bytesWrittenSubject = BehaviorSubject.l0(0L);
        this.estimatedContentLength = requestBody.contentLength();
    }
}
