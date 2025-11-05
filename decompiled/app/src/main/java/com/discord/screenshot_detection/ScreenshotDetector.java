package com.discord.screenshot_detection;

import android.app.Application;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.a.s.b;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import rx.subjects.PublishSubject;

/* compiled from: ScreenshotDetector.kt */
/* loaded from: classes.dex */
public final class ScreenshotDetector {
    public static ScreenshotDetector a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final PublishSubject<Screenshot> publishSubject;

    /* renamed from: c, reason: from kotlin metadata */
    public final b screenshotContentObserver;

    /* renamed from: d, reason: from kotlin metadata */
    public final b.a.s.a activityCallbacks;

    /* renamed from: e, reason: from kotlin metadata */
    public boolean enabled;

    /* renamed from: f, reason: from kotlin metadata */
    public final Logger logger;

    /* renamed from: g, reason: from kotlin metadata */
    public final SharedPreferences cache;

    /* compiled from: ScreenshotDetector.kt */
    public static final /* data */ class Screenshot {

        /* renamed from: a, reason: from kotlin metadata */
        public final Uri uri;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String filename;

        public Screenshot(Uri uri, String str) {
            m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            m.checkNotNullParameter(str, "filename");
            this.uri = uri;
            this.filename = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Screenshot)) {
                return false;
            }
            Screenshot screenshot = (Screenshot) other;
            return m.areEqual(this.uri, screenshot.uri) && m.areEqual(this.filename, screenshot.filename);
        }

        public int hashCode() {
            Uri uri = this.uri;
            int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
            String str = this.filename;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("Screenshot(uri=");
            sbU.append(this.uri);
            sbU.append(", filename=");
            return b.d.b.a.a.J(sbU, this.filename, ")");
        }
    }

    /* compiled from: ScreenshotDetector.kt */
    public static final class a extends o implements Function2<Uri, String, Unit> {
        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Uri uri, String str) {
            Uri uri2 = uri;
            String str2 = str;
            m.checkNotNullParameter(uri2, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            m.checkNotNullParameter(str2, "filename");
            ScreenshotDetector screenshotDetector = ScreenshotDetector.this;
            if (screenshotDetector.enabled) {
                PublishSubject<Screenshot> publishSubject = screenshotDetector.publishSubject;
                publishSubject.k.onNext(new Screenshot(uri2, str2));
            }
            return Unit.a;
        }
    }

    public ScreenshotDetector(Application application, Logger logger, SharedPreferences sharedPreferences) {
        m.checkNotNullParameter(application, "applicationContext");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(sharedPreferences, "cache");
        this.logger = logger;
        this.cache = sharedPreferences;
        PublishSubject<Screenshot> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.publishSubject = publishSubjectK0;
        ContentResolver contentResolver = application.getContentResolver();
        m.checkNotNullExpressionValue(contentResolver, "applicationContext.contentResolver");
        b bVar = new b(logger, contentResolver, null, new a(), 4);
        this.screenshotContentObserver = bVar;
        b.a.s.a aVar = new b.a.s.a(bVar);
        this.activityCallbacks = aVar;
        a(sharedPreferences.getBoolean("screenshot_detection_enabled", false));
        application.registerActivityLifecycleCallbacks(aVar);
        aVar.a(this.enabled);
    }

    public final void a(boolean z2) {
        this.enabled = z2;
        SharedPreferences.Editor editorEdit = this.cache.edit();
        m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("screenshot_detection_enabled", z2);
        editorEdit.apply();
        this.activityCallbacks.a(z2);
    }
}
