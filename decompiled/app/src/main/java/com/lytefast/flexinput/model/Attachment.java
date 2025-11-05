package com.lytefast.flexinput.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import b.c.a.a0.d;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.w;
import d0.y.b;
import d0.z.d.m;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Attachment.kt */
/* loaded from: classes3.dex */
public class Attachment<T> implements Parcelable {
    private static final String SPOILER_PREFIX = "SPOILER_";
    private final T data;
    private final String displayName;
    private final long id;
    private boolean spoiler;
    private final Uri uri;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Attachment<?>> CREATOR = new a();

    /* compiled from: Attachment.kt */
    public static final class Companion {
        public Companion() {
        }

        public final String a(Attachment<?> attachment) {
            m.checkNotNullParameter(attachment, "$this$getSendName");
            if (!attachment.getSpoiler()) {
                return attachment.getDisplayName();
            }
            StringBuilder sbU = b.d.b.a.a.U("SPOILER_");
            sbU.append(attachment.getDisplayName());
            return sbU.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Attachment<Uri> b(Uri uri, ContentResolver contentResolver) throws IOException {
            String lastPathSegment;
            int columnIndex;
            m.checkNotNullParameter(uri, "$this$toAttachment");
            m.checkNotNullParameter(contentResolver, "resolver");
            m.checkNotNullParameter(uri, "$this$getFileName");
            m.checkNotNullParameter(contentResolver, "contentResolver");
            String scheme = uri.getScheme();
            if (scheme == null) {
                lastPathSegment = uri.getLastPathSegment();
            } else {
                int iHashCode = scheme.hashCode();
                lastPathSegment = null;
                if (iHashCode != 3143036) {
                    if (iHashCode == 951530617 && scheme.equals("content")) {
                        try {
                            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
                            if (cursorQuery != null) {
                                try {
                                    if (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_display_name")) < 0) {
                                        b.closeFinally(cursorQuery, null);
                                        lastPathSegment = uri.getLastPathSegment();
                                    } else {
                                        String string = cursorQuery.getString(columnIndex);
                                        if (string == null) {
                                            string = uri.getLastPathSegment();
                                        }
                                        b.closeFinally(cursorQuery, null);
                                        lastPathSegment = string;
                                    }
                                } finally {
                                }
                            } else {
                                lastPathSegment = uri.getLastPathSegment();
                            }
                        } catch (NullPointerException e) {
                            StringBuilder sbU = b.d.b.a.a.U("Error getting file name for: ");
                            sbU.append(uri.getPath());
                            Log.e("FileUtils", sbU.toString(), e);
                            lastPathSegment = uri.getLastPathSegment();
                        }
                    }
                } else if (scheme.equals("file")) {
                    String path = uri.getPath();
                    if (path != null) {
                        lastPathSegment = new File(path).getName();
                    }
                }
            }
            if (lastPathSegment == null) {
                lastPathSegment = String.valueOf(uri.hashCode());
            }
            return new Attachment<>(uri.hashCode(), uri, lastPathSegment, null, false, 16, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Attachment<InputContentInfoCompat> c(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
            String str2;
            m.checkNotNullParameter(inputContentInfoCompat, "$this$toAttachment");
            m.checkNotNullParameter(contentResolver, "resolver");
            m.checkNotNullParameter(str, "defaultName");
            String queryParameter = inputContentInfoCompat.getContentUri().getQueryParameter("fileName");
            if (queryParameter != null) {
                str = queryParameter;
            }
            m.checkNotNullExpressionValue(str, "contentUri.getQueryParam…fileName\") ?: defaultName");
            String strSubstringAfterLast$default = w.substringAfterLast$default(str, File.separatorChar, null, 2, null);
            if (z2) {
                String mimeType = inputContentInfoCompat.getDescription().getMimeType(0);
                if (mimeType == null) {
                    mimeType = inputContentInfoCompat.getContentUri().getQueryParameter("mimeType");
                }
                if (mimeType == null) {
                    mimeType = contentResolver.getType(inputContentInfoCompat.getContentUri());
                }
                if (mimeType != null) {
                    String str3 = strSubstringAfterLast$default + '.' + w.substringAfterLast$default(mimeType, MentionUtilsKt.SLASH_CHAR, null, 2, null);
                    if (str3 != null) {
                        str2 = str3;
                    }
                }
            } else {
                str2 = strSubstringAfterLast$default;
            }
            long jHashCode = inputContentInfoCompat.getContentUri().hashCode();
            Uri contentUri = inputContentInfoCompat.getContentUri();
            m.checkNotNullExpressionValue(contentUri, "contentUri");
            return new Attachment<>(jHashCode, contentUri, str2, inputContentInfoCompat, false, 16, null);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: Attachment.kt */
    public static final class a implements Parcelable.Creator<Attachment<?>> {
        @Override // android.os.Parcelable.Creator
        public Attachment<?> createFromParcel(Parcel parcel) {
            m.checkNotNullParameter(parcel, "parcelIn");
            return new Attachment<>(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Attachment<?>[] newArray(int i) {
            return new Attachment[i];
        }
    }

    public Attachment(long j, Uri uri, String str, T t, boolean z2) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        m.checkNotNullParameter(str, "displayName");
        this.id = j;
        this.uri = uri;
        this.displayName = str;
        this.data = t;
        this.spoiler = z2;
    }

    public static final Attachment<Uri> toAttachment(Uri uri, ContentResolver contentResolver) {
        return INSTANCE.b(uri, contentResolver);
    }

    public static final Attachment<InputContentInfoCompat> toAttachment(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
        return INSTANCE.c(inputContentInfoCompat, contentResolver, z2, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) other;
        return this.id == attachment.id && m.areEqual(this.uri, attachment.uri) && this.spoiler == attachment.spoiler;
    }

    public final T getData() {
        return this.data;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getSpoiler() {
        return this.spoiler;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return d.K0(Long.valueOf(this.id), this.uri);
    }

    public final void setSpoiler(boolean z2) {
        this.spoiler = z2;
    }

    @Override // android.os.Parcelable
    @CallSuper
    public void writeToParcel(Parcel dest, int flags) {
        m.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeParcelable(this.uri, flags);
        dest.writeString(this.displayName);
        dest.writeInt(this.spoiler ? 1 : 0);
    }

    public /* synthetic */ Attachment(long j, Uri uri, String str, Object obj, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, uri, str, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? false : z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Attachment(Parcel parcel) {
        m.checkNotNullParameter(parcel, "parcelIn");
        long j = parcel.readLong();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            m.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        }
        Uri uri2 = uri;
        String string = parcel.readString();
        String str = string == null ? "" : string;
        m.checkNotNullExpressionValue(str, "parcelIn.readString() ?: \"\"");
        this(j, uri2, str, null, parcel.readInt() == 1);
    }
}
