package com.discord.utilities.attachments;

import android.content.ClipDescription;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.discord.api.message.LocalAttachment;
import com.discord.utilities.string.StringUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import d0.g;
import d0.g0.t;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import g0.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import org.webrtc.MediaStreamTrack;

/* compiled from: AttachmentUtils.kt */
/* loaded from: classes2.dex */
public final class AttachmentUtilsKt {
    private static final int UTF_8_RANGE_END_EXCLUSIVE = 126;
    private static final int UTF_8_RANGE_START_EXCLUSIVE = 32;
    private static final Lazy REGEX_FILE_NAME_PATTERN$delegate = g.lazy(AttachmentUtilsKt$REGEX_FILE_NAME_PATTERN$2.INSTANCE);
    private static final IntRange UTF_8_RANGE_EXCLUSIVE = new IntRange(32, 126);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Bitmap.CompressFormat.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            $EnumSwitchMapping$1 = iArr;
            iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            iArr[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
        }
    }

    /* compiled from: AttachmentUtils.kt */
    /* renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$appendLinks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Attachment<?>, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(Attachment<?> attachment) {
            m.checkNotNullParameter(attachment, "it");
            Object data = attachment.getData();
            Objects.requireNonNull(data, "null cannot be cast to non-null type androidx.core.view.inputmethod.InputContentInfoCompat");
            InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
            String strValueOf = String.valueOf(inputContentInfoCompat.getLinkUri());
            inputContentInfoCompat.releasePermission();
            return strValueOf;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Attachment<?> attachment) {
            return invoke2(attachment);
        }
    }

    /* compiled from: AttachmentUtils.kt */
    /* renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$getMimeType$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String str) {
            m.checkNotNullParameter(str, "file");
            Matcher matcher = AttachmentUtilsKt.access$getREGEX_FILE_NAME_PATTERN$p().matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(matcher.group(2));
        }
    }

    public static final /* synthetic */ Pattern access$getREGEX_FILE_NAME_PATTERN$p() {
        return getREGEX_FILE_NAME_PATTERN();
    }

    public static final String appendLinks(String str, List<? extends Attachment<?>> list) {
        m.checkNotNullParameter(str, "content");
        m.checkNotNullParameter(list, "links");
        return str + "\n" + u.joinToString$default(list, "\n", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    }

    public static final List<Attachment<?>> extractLinks(List<? extends Attachment<?>> list, ContentResolver contentResolver) {
        m.checkNotNullParameter(list, "$this$extractLinks");
        m.checkNotNullParameter(contentResolver, "contentResolver");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Attachment attachment = (Attachment) obj;
            Object data = attachment.getData();
            if (!(data instanceof InputContentInfoCompat)) {
                data = null;
            }
            InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
            if ((inputContentInfoCompat == null || inputContentInfoCompat.getLinkUri() == null || !m.areEqual(getMimeType(attachment, contentResolver), "image/gif")) ? false : true) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static final String getExtension(Bitmap.CompressFormat compressFormat) {
        int i = WhenMappings.$EnumSwitchMapping$1[compressFormat.ordinal()];
        return i != 1 ? i != 2 ? "jpg" : "webp" : "png";
    }

    public static final String getMimeType(ContentResolver contentResolver, Uri uri, String str) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        String strInvoke2 = null;
        String type = contentResolver != null ? contentResolver.getType(uri) : null;
        if (type != null) {
            return type;
        }
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        try {
            String strInvoke22 = anonymousClass1.invoke2(String.valueOf(uri));
            strInvoke2 = strInvoke22 != null ? strInvoke22 : anonymousClass1.invoke2(String.valueOf(str));
        } catch (Exception unused) {
        }
        return strInvoke2 != null ? strInvoke2 : "application/octet-stream";
    }

    public static /* synthetic */ String getMimeType$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return getMimeType(contentResolver, uri, str);
    }

    private static final Pattern getREGEX_FILE_NAME_PATTERN() {
        return (Pattern) REGEX_FILE_NAME_PATTERN$delegate.getValue();
    }

    public static final String getSanitizedFileName(String str, Bitmap.CompressFormat compressFormat) {
        m.checkNotNullParameter(str, "fileName");
        if (compressFormat != null) {
            Matcher matcher = getREGEX_FILE_NAME_PATTERN().matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
            }
            str = str + '.' + getExtension(compressFormat);
        }
        return toHumanReadableAscii(StringUtilsKt.stripAccents(str));
    }

    public static final boolean isGif(Attachment<?> attachment, ContentResolver contentResolver) {
        m.checkNotNullParameter(attachment, "$this$isGif");
        return m.areEqual(getMimeType(attachment, contentResolver), "image/gif");
    }

    public static final boolean isImage(ContentResolver contentResolver, Uri uri, String str) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return t.startsWith$default(getMimeType(contentResolver, uri, str), "image", false, 2, null);
    }

    public static /* synthetic */ boolean isImage$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return isImage(contentResolver, uri, str);
    }

    public static final boolean isImageAttachment(LocalAttachment localAttachment, ContentResolver contentResolver) {
        m.checkNotNullParameter(localAttachment, "$this$isImageAttachment");
        m.checkNotNullParameter(contentResolver, "contentResolver");
        Uri uri = Uri.parse(localAttachment.getUriString());
        m.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return isImage(contentResolver, uri, localAttachment.getDisplayName());
    }

    public static final boolean isVideo(ContentResolver contentResolver, Uri uri, String str) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return t.startsWith$default(getMimeType(contentResolver, uri, str), MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null);
    }

    public static /* synthetic */ boolean isVideo$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return isVideo(contentResolver, uri, str);
    }

    public static final boolean isVideoAttachment(LocalAttachment localAttachment, ContentResolver contentResolver) {
        m.checkNotNullParameter(localAttachment, "$this$isVideoAttachment");
        m.checkNotNullParameter(contentResolver, "contentResolver");
        Uri uri = Uri.parse(localAttachment.getUriString());
        m.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return isVideo(contentResolver, uri, localAttachment.getDisplayName());
    }

    public static final Attachment toAttachment(LocalAttachment localAttachment) {
        m.checkNotNullParameter(localAttachment, "$this$toAttachment");
        long id2 = localAttachment.getId();
        Uri uri = Uri.parse(localAttachment.getUriString());
        m.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return new Attachment(id2, uri, localAttachment.getDisplayName(), null, false, 16, null);
    }

    private static final String toHumanReadableAscii(String str) {
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!UTF_8_RANGE_EXCLUSIVE.contains(iCodePointAt)) {
                e eVar = new e();
                eVar.c0(str, 0, iCharCount);
                while (iCharCount < str.length()) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    eVar.d0(UTF_8_RANGE_EXCLUSIVE.contains(iCodePointAt2) ? iCodePointAt2 : 63);
                    iCharCount += Character.charCount(iCodePointAt2);
                }
                return eVar.D();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public static final LocalAttachment toLocalAttachment(Attachment<?> attachment) {
        m.checkNotNullParameter(attachment, "$this$toLocalAttachment");
        long id2 = attachment.getId();
        String string = attachment.getUri().toString();
        m.checkNotNullExpressionValue(string, "uri.toString()");
        return new LocalAttachment(id2, string, attachment.getDisplayName());
    }

    public static final boolean isImage(Attachment<?> attachment, ContentResolver contentResolver) {
        m.checkNotNullParameter(attachment, "$this$isImage");
        return t.startsWith$default(getMimeType(attachment, contentResolver), "image", false, 2, null);
    }

    public static final boolean isVideo(Attachment<?> attachment, ContentResolver contentResolver) {
        m.checkNotNullParameter(attachment, "$this$isVideo");
        return t.startsWith$default(getMimeType(attachment, contentResolver), MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null);
    }

    public static final String getMimeType(Attachment<?> attachment, ContentResolver contentResolver) {
        ClipDescription description;
        m.checkNotNullParameter(attachment, "$this$getMimeType");
        Object data = attachment.getData();
        String mimeType = null;
        if (!(data instanceof InputContentInfoCompat)) {
            data = null;
        }
        InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
        if (inputContentInfoCompat != null && (description = inputContentInfoCompat.getDescription()) != null) {
            mimeType = description.getMimeType(0);
        }
        return mimeType != null ? mimeType : getMimeType(contentResolver, attachment.getUri(), attachment.getDisplayName());
    }
}
