package b.a.s;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.t;
import d0.g0.w;
import d0.t.j;
import d0.z.d.m;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ScreenshotContentObserver.kt */
/* loaded from: classes.dex */
public final class b extends ContentObserver {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public String f285b;
    public final Logger c;
    public final ContentResolver d;
    public final Clock e;
    public final Function2<Uri, String, Unit> f;

    /* compiled from: ScreenshotContentObserver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: ScreenshotContentObserver.kt */
    /* renamed from: b.a.s.b$b, reason: collision with other inner class name */
    public static final class C0049b {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final long f286b;
        public final String c;
        public final String d;
        public final Uri e;
        public final long f;

        public C0049b(long j, String str, String str2, Uri uri, long j2) {
            m.checkNotNullParameter(str, "fileName");
            m.checkNotNullParameter(str2, "relativePath");
            m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            this.f286b = j;
            this.c = str;
            this.d = str2;
            this.e = uri;
            this.f = j2;
            this.a = str2 + MentionUtilsKt.SLASH_CHAR + str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0049b)) {
                return false;
            }
            C0049b c0049b = (C0049b) obj;
            return this.f286b == c0049b.f286b && m.areEqual(this.c, c0049b.c) && m.areEqual(this.d, c0049b.d) && m.areEqual(this.e, c0049b.e) && this.f == c0049b.f;
        }

        public int hashCode() {
            int iA = a0.a.a.b.a(this.f286b) * 31;
            String str = this.c;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.d;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Uri uri = this.e;
            return a0.a.a.b.a(this.f) + ((iHashCode2 + (uri != null ? uri.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ScreenshotData(id=");
            sbU.append(this.f286b);
            sbU.append(", fileName=");
            sbU.append(this.c);
            sbU.append(", relativePath=");
            sbU.append(this.d);
            sbU.append(", uri=");
            sbU.append(this.e);
            sbU.append(", dateAdded=");
            return b.d.b.a.a.C(sbU, this.f, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Logger logger, ContentResolver contentResolver, Clock clock, Function2 function2, int i) {
        super(null);
        Clock clock2 = (i & 4) != 0 ? ClockFactory.get() : null;
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(contentResolver, "contentResolver");
        m.checkNotNullParameter(clock2, "clock");
        m.checkNotNullParameter(function2, "onScreenshot");
        this.c = logger;
        this.d = contentResolver;
        this.e = clock2;
        this.f = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Uri uri) throws IOException {
        String strSubstringBeforeLast$default;
        C0049b c0049b;
        ContentResolver contentResolver = this.d;
        int i = Build.VERSION.SDK_INT;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) j.plus(j.plus(new String[]{"_display_name", "date_added", "_id"}, i >= 29 ? new String[]{"is_pending", "relative_path"} : new String[0]), i >= 29 ? new String[]{"relative_path"} : new String[]{"_data"}), null, null, "date_added DESC");
        if (cursorQuery != null) {
            try {
                if (!cursorQuery.moveToFirst()) {
                    d0.y.b.closeFinally(cursorQuery, null);
                } else if (i < 29 || cursorQuery.getInt(cursorQuery.getColumnIndex("is_pending")) != 1) {
                    if (i >= 29) {
                        strSubstringBeforeLast$default = cursorQuery.getString(cursorQuery.getColumnIndex("relative_path"));
                    } else {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                        m.checkNotNullExpressionValue(string, "cursor.getString(cursor.…mages.ImageColumns.DATA))");
                        strSubstringBeforeLast$default = w.substringBeforeLast$default(string, MentionUtilsKt.SLASH_CHAR, (String) null, 2, (Object) null);
                    }
                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    m.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…ages.Media.DISPLAY_NAME))");
                    m.checkNotNullExpressionValue(strSubstringBeforeLast$default, "relativePath");
                    c0049b = new C0049b(j, string2, strSubstringBeforeLast$default, uri, cursorQuery.getLong(cursorQuery.getColumnIndex("date_added")));
                    d0.y.b.closeFinally(cursorQuery, null);
                } else {
                    d0.y.b.closeFinally(cursorQuery, null);
                }
                c0049b = null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    d0.y.b.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        if (c0049b != null) {
            String str = this.f285b;
            if (str == null || !t.equals$default(str, c0049b.a, false, 2, null)) {
                String str2 = c0049b.a;
                Locale locale = Locale.getDefault();
                m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str2.toLowerCase(locale);
                m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (w.contains$default((CharSequence) lowerCase, (CharSequence) "screenshots/", false, 2, (Object) null)) {
                    if (Math.abs((this.e.currentTimeMillis() / ((long) 1000)) - c0049b.f) <= 10) {
                        this.f285b = c0049b.a;
                        this.f.invoke(c0049b.e, c0049b.c);
                    }
                }
            }
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2, Uri uri) {
        super.onChange(z2, uri);
        if (uri != null) {
            String string = uri.toString();
            m.checkNotNullExpressionValue(string, "uri.toString()");
            String string2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            m.checkNotNullExpressionValue(string2, "MediaStore.Images.Media.…AL_CONTENT_URI.toString()");
            if (t.startsWith$default(string, string2, false, 2, null)) {
                try {
                    a(uri);
                } catch (Exception e) {
                    Logger.e$default(this.c, "Error processing screenshot", e, null, 4, null);
                }
            }
        }
    }
}
