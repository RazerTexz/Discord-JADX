package com.discord.utilities.file;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ResponseBody;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: DownloadUtils.kt */
/* loaded from: classes2.dex */
public final class DownloadUtils {
    public static final DownloadUtils INSTANCE = new DownloadUtils();

    /* compiled from: DownloadUtils.kt */
    public static abstract class DownloadState {

        /* compiled from: DownloadUtils.kt */
        public static final class Completed extends DownloadState {
            private final File file;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Completed(File file) {
                super(null);
                m.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final File getFile() {
                return this.file;
            }
        }

        /* compiled from: DownloadUtils.kt */
        public static final class Failure extends DownloadState {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(Exception exc) {
                super(null);
                m.checkNotNullParameter(exc, "exception");
                this.exception = exc;
            }

            public final Exception getException() {
                return this.exception;
            }
        }

        /* compiled from: DownloadUtils.kt */
        public static final class InProgress extends DownloadState {
            private final float progress;

            public InProgress(float f) {
                super(null);
                this.progress = f;
            }

            public final float getProgress() {
                return this.progress;
            }
        }

        private DownloadState() {
        }

        public /* synthetic */ DownloadState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DownloadUtils.kt */
    /* renamed from: com.discord.utilities.file.DownloadUtils$downloadFile$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Emitter<DownloadState>> {
        public final /* synthetic */ File $downloadDirectory;
        public final /* synthetic */ String $fileName;
        public final /* synthetic */ String $fileUrl;

        /* compiled from: DownloadUtils.kt */
        /* renamed from: com.discord.utilities.file.DownloadUtils$downloadFile$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03331 extends o implements Function1<ResponseBody, Unit> {
            public final /* synthetic */ Emitter $emitter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03331(Emitter emitter) {
                super(1);
                this.$emitter = emitter;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResponseBody responseBody) {
                invoke2(responseBody);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResponseBody responseBody) {
                m.checkNotNullParameter(responseBody, "responseBody");
                try {
                    try {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        File file = new File(anonymousClass1.$downloadDirectory, anonymousClass1.$fileName);
                        byte[] bArr = new byte[8192];
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        float fA = responseBody.a();
                        int i = 0;
                        while (true) {
                            int i2 = responseBody.c().u0().read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            i += i2;
                            this.$emitter.onNext(new DownloadState.InProgress(i / fA));
                            fileOutputStream.write(bArr, 0, i2);
                        }
                        this.$emitter.onNext(new DownloadState.Completed(file));
                        this.$emitter.onCompleted();
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.$emitter.onNext(new DownloadState.Failure(e));
                    }
                } finally {
                    responseBody.close();
                }
            }
        }

        public AnonymousClass1(String str, File file, String str2) {
            this.$fileUrl = str;
            this.$downloadDirectory = file;
            this.$fileName = str2;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<DownloadState> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<DownloadState> emitter) {
            m.checkNotNullParameter(emitter, "emitter");
            emitter.onNext(new DownloadState.InProgress(0.0f));
            ObservableExtensionsKt.appSubscribe$default(RestAPI.INSTANCE.getApiFiles().getFile(this.$fileUrl), DownloadUtils.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C03331(emitter), 62, (Object) null);
        }
    }

    private DownloadUtils() {
    }

    @RequiresPermission(conditional = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "android.permission.WRITE_EXTERNAL_STORAGE")
    public static final Observable<DownloadState> downloadFile(Context context, String fileUrl, String fileName, File downloadDirectory) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fileUrl, "fileUrl");
        m.checkNotNullParameter(fileName, "fileName");
        m.checkNotNullParameter(downloadDirectory, "downloadDirectory");
        Observable<DownloadState> observableO = Observable.o(new AnonymousClass1(fileUrl, downloadDirectory, fileName), Emitter.BackpressureMode.BUFFER);
        m.checkNotNullExpressionValue(observableO, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return observableO;
    }

    public static /* synthetic */ Observable downloadFile$default(Context context, String str, String str2, File file, int i, Object obj) {
        if ((i & 8) != 0) {
            file = context.getCacheDir();
            m.checkNotNullExpressionValue(file, "context.cacheDir");
        }
        return downloadFile(context, str, str2, file);
    }
}
