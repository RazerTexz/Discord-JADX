package com.facebook.datasource;

import java.util.Map;
import java.util.concurrent.Executor;
import p007b.p109f.p129e.DataSubscriber;

/* loaded from: classes.dex */
public interface DataSource<T> {
    /* renamed from: a */
    Map<String, Object> mo1017a();

    /* renamed from: b */
    boolean mo1018b();

    /* renamed from: c */
    boolean mo1019c();

    boolean close();

    /* renamed from: d */
    Throwable mo1020d();

    /* renamed from: e */
    boolean mo1021e();

    /* renamed from: f */
    void mo1022f(DataSubscriber<T> dataSubscriber, Executor executor);

    float getProgress();

    T getResult();
}
