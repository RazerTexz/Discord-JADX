package p007b.p008a.p049s;

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
import com.discord.widgets.chat.input.MentionUtils;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t._ArraysJvm;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ScreenshotContentObserver.kt */
/* renamed from: b.a.s.b, reason: use source file name */
/* loaded from: classes.dex */
public final class ScreenshotContentObserver extends ContentObserver {

    /* renamed from: a */
    public static final a f1879a = new a(null);

    /* renamed from: b */
    public String f1880b;

    /* renamed from: c */
    public final Logger f1881c;

    /* renamed from: d */
    public final ContentResolver f1882d;

    /* renamed from: e */
    public final Clock f1883e;

    /* renamed from: f */
    public final Function2<Uri, String, Unit> f1884f;

    /* compiled from: ScreenshotContentObserver.kt */
    /* renamed from: b.a.s.b$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: ScreenshotContentObserver.kt */
    /* renamed from: b.a.s.b$b */
    public static final class b {

        /* renamed from: a */
        public final String f1885a;

        /* renamed from: b */
        public final long f1886b;

        /* renamed from: c */
        public final String f1887c;

        /* renamed from: d */
        public final String f1888d;

        /* renamed from: e */
        public final Uri f1889e;

        /* renamed from: f */
        public final long f1890f;

        public b(long j, String str, String str2, Uri uri, long j2) {
            Intrinsics3.checkNotNullParameter(str, "fileName");
            Intrinsics3.checkNotNullParameter(str2, "relativePath");
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            this.f1886b = j;
            this.f1887c = str;
            this.f1888d = str2;
            this.f1889e = uri;
            this.f1890f = j2;
            this.f1885a = str2 + MentionUtils.SLASH_CHAR + str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1886b == bVar.f1886b && Intrinsics3.areEqual(this.f1887c, bVar.f1887c) && Intrinsics3.areEqual(this.f1888d, bVar.f1888d) && Intrinsics3.areEqual(this.f1889e, bVar.f1889e) && this.f1890f == bVar.f1890f;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.f1886b) * 31;
            String str = this.f1887c;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f1888d;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Uri uri = this.f1889e;
            return C0002b.m3a(this.f1890f) + ((iHashCode2 + (uri != null ? uri.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ScreenshotData(id=");
            sbM833U.append(this.f1886b);
            sbM833U.append(", fileName=");
            sbM833U.append(this.f1887c);
            sbM833U.append(", relativePath=");
            sbM833U.append(this.f1888d);
            sbM833U.append(", uri=");
            sbM833U.append(this.f1889e);
            sbM833U.append(", dateAdded=");
            return outline.m815C(sbM833U, this.f1890f, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotContentObserver(Logger logger, ContentResolver contentResolver, Clock clock, Function2 function2, int i) {
        super(null);
        Clock clock2 = (i & 4) != 0 ? ClockFactory.get() : null;
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(clock2, "clock");
        Intrinsics3.checkNotNullParameter(function2, "onScreenshot");
        this.f1881c = logger;
        this.f1882d = contentResolver;
        this.f1883e = clock2;
        this.f1884f = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m365a(Uri uri) throws IOException {
        String strSubstringBeforeLast$default;
        b bVar;
        ContentResolver contentResolver = this.f1882d;
        int i = Build.VERSION.SDK_INT;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) _ArraysJvm.plus(_ArraysJvm.plus(new String[]{"_display_name", "date_added", "_id"}, i >= 29 ? new String[]{"is_pending", "relative_path"} : new String[0]), i >= 29 ? new String[]{"relative_path"} : new String[]{"_data"}), null, null, "date_added DESC");
        if (cursorQuery != null) {
            try {
                if (!cursorQuery.moveToFirst()) {
                    Closeable.closeFinally(cursorQuery, null);
                } else if (i < 29 || cursorQuery.getInt(cursorQuery.getColumnIndex("is_pending")) != 1) {
                    if (i >= 29) {
                        strSubstringBeforeLast$default = cursorQuery.getString(cursorQuery.getColumnIndex("relative_path"));
                    } else {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                        Intrinsics3.checkNotNullExpressionValue(string, "cursor.getString(cursor.…mages.ImageColumns.DATA))");
                        strSubstringBeforeLast$default = Strings4.substringBeforeLast$default(string, MentionUtils.SLASH_CHAR, (String) null, 2, (Object) null);
                    }
                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    Intrinsics3.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…ages.Media.DISPLAY_NAME))");
                    Intrinsics3.checkNotNullExpressionValue(strSubstringBeforeLast$default, "relativePath");
                    bVar = new b(j, string2, strSubstringBeforeLast$default, uri, cursorQuery.getLong(cursorQuery.getColumnIndex("date_added")));
                    Closeable.closeFinally(cursorQuery, null);
                } else {
                    Closeable.closeFinally(cursorQuery, null);
                }
                bVar = null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        if (bVar != null) {
            String str = this.f1880b;
            if (str == null || !StringsJVM.equals$default(str, bVar.f1885a, false, 2, null)) {
                String str2 = bVar.f1885a;
                Locale locale = Locale.getDefault();
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str2.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (Strings4.contains$default((CharSequence) lowerCase, (CharSequence) "screenshots/", false, 2, (Object) null)) {
                    if (Math.abs((this.f1883e.currentTimeMillis() / ((long) 1000)) - bVar.f1890f) <= 10) {
                        this.f1880b = bVar.f1885a;
                        this.f1884f.invoke(bVar.f1889e, bVar.f1887c);
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
            Intrinsics3.checkNotNullExpressionValue(string, "uri.toString()");
            String string2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            Intrinsics3.checkNotNullExpressionValue(string2, "MediaStore.Images.Media.…AL_CONTENT_URI.toString()");
            if (StringsJVM.startsWith$default(string, string2, false, 2, null)) {
                try {
                    m365a(uri);
                } catch (Exception e) {
                    Logger.e$default(this.f1881c, "Error processing screenshot", e, null, 4, null);
                }
            }
        }
    }
}
