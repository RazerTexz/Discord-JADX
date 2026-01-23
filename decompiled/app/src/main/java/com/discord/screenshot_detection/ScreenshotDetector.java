package com.discord.screenshot_detection;

import android.app.Application;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p049s.ScreenshotContentObserver;
import p007b.p008a.p049s.ScreenshotDetector2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ScreenshotDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenshotDetector {

    /* JADX INFO: renamed from: a */
    public static ScreenshotDetector f18938a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final PublishSubject<Screenshot> publishSubject;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final ScreenshotContentObserver screenshotContentObserver;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final ScreenshotDetector2 activityCallbacks;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean enabled;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Logger logger;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final SharedPreferences cache;

    /* JADX INFO: compiled from: ScreenshotDetector.kt */
    public static final /* data */ class Screenshot {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final Uri uri;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String filename;

        public Screenshot(Uri uri, String str) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(str, "filename");
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
            return Intrinsics3.areEqual(this.uri, screenshot.uri) && Intrinsics3.areEqual(this.filename, screenshot.filename);
        }

        public int hashCode() {
            Uri uri = this.uri;
            int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
            String str = this.filename;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Screenshot(uri=");
            sbM833U.append(this.uri);
            sbM833U.append(", filename=");
            return outline.m822J(sbM833U, this.filename, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.screenshot_detection.ScreenshotDetector$a */
    /* JADX INFO: compiled from: ScreenshotDetector.kt */
    public static final class C5652a extends Lambda implements Function2<Uri, String, Unit> {
        public C5652a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Uri uri, String str) {
            Uri uri2 = uri;
            String str2 = str;
            Intrinsics3.checkNotNullParameter(uri2, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(str2, "filename");
            ScreenshotDetector screenshotDetector = ScreenshotDetector.this;
            if (screenshotDetector.enabled) {
                PublishSubject<Screenshot> publishSubject = screenshotDetector.publishSubject;
                publishSubject.f27650k.onNext(new Screenshot(uri2, str2));
            }
            return Unit.f27425a;
        }
    }

    public ScreenshotDetector(Application application, Logger logger, SharedPreferences sharedPreferences) {
        Intrinsics3.checkNotNullParameter(application, "applicationContext");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(sharedPreferences, "cache");
        this.logger = logger;
        this.cache = sharedPreferences;
        PublishSubject<Screenshot> publishSubjectM11133k0 = PublishSubject.m11133k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.publishSubject = publishSubjectM11133k0;
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "applicationContext.contentResolver");
        ScreenshotContentObserver screenshotContentObserver = new ScreenshotContentObserver(logger, contentResolver, null, new C5652a(), 4);
        this.screenshotContentObserver = screenshotContentObserver;
        ScreenshotDetector2 screenshotDetector2 = new ScreenshotDetector2(screenshotContentObserver);
        this.activityCallbacks = screenshotDetector2;
        m8505a(sharedPreferences.getBoolean("screenshot_detection_enabled", false));
        application.registerActivityLifecycleCallbacks(screenshotDetector2);
        screenshotDetector2.m364a(this.enabled);
    }

    /* JADX INFO: renamed from: a */
    public final void m8505a(boolean z2) {
        this.enabled = z2;
        SharedPreferences.Editor editorEdit = this.cache.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("screenshot_detection_enabled", z2);
        editorEdit.apply();
        this.activityCallbacks.m364a(z2);
    }
}
