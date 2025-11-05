package b.f.e;

import com.facebook.datasource.DataSource;

/* compiled from: DataSubscriber.java */
/* loaded from: classes.dex */
public interface f<T> {
    void onCancellation(DataSource<T> dataSource);

    void onFailure(DataSource<T> dataSource);

    void onNewResult(DataSource<T> dataSource);

    void onProgressUpdate(DataSource<T> dataSource);
}
