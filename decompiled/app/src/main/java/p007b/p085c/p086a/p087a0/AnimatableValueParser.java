package p007b.p085c.p086a.p087a0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.os.Trace;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.adjust.sdk.Constants;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppPermissions2;
import com.discord.i18n.RenderContext;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$FileDeleteException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.C10638R;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import com.facebook.soloader.SysUtil$MarshmallowSysdeps;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.Inflater;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;
import org.objectweb.asm.Opcodes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p007b.p008a.p050t.p052b.p055c.NodeProcessor;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p095y.p096k.AnimatableColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p096k.AnimatablePointValue;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p111b.p112a.MultiCacheKey;
import p007b.p109f.p115d.p118c.FileTreeVisitor;
import p007b.p109f.p115d.p119d.Objects2;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p129e.SimpleDataSource;
import p007b.p109f.p132g.p142e.ArrayDrawable2;
import p007b.p109f.p132g.p142e.AutoRotateDrawable;
import p007b.p109f.p132g.p142e.C1763b0;
import p007b.p109f.p132g.p142e.C1784r;
import p007b.p109f.p132g.p142e.C1785s;
import p007b.p109f.p132g.p142e.C1786t;
import p007b.p109f.p132g.p142e.C1787u;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p132g.p142e.C1789w;
import p007b.p109f.p132g.p142e.C1790x;
import p007b.p109f.p132g.p142e.C1792z;
import p007b.p109f.p132g.p142e.DrawableParent;
import p007b.p109f.p132g.p142e.DrawableProperties;
import p007b.p109f.p132g.p142e.ScaleTypeDrawable;
import p007b.p109f.p132g.p142e.TransformAwareDrawable;
import p007b.p109f.p132g.p142e.TransformCallback;
import p007b.p109f.p132g.p143f.GenericDraweeHierarchyBuilder;
import p007b.p109f.p132g.p143f.RoundingParams;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p185t.BitmapTransformation;
import p007b.p109f.p190m.MinElf;
import p007b.p109f.p190m.p191n.NativeLoader;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p210c0.TypeResolutionContext;
import p007b.p195g.p196a.p205c.p218h0.TypeBindings;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p225i.p226a.p228b.p229i.CctTransportBackend;
import p007b.p225i.p226a.p228b.p229i.CctTransportBackend3;
import p007b.p225i.p226a.p228b.p231j.p235s.RetryStrategy;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.p252t.TtmlStyle;
import p007b.p225i.p226a.p242c.p256d3.C2664h;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.p261z.Projection;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.FlacStreamMetadata;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.VorbisUtil3;
import p007b.p225i.p226a.p242c.p267x2.p274i0.PsshAtomUtil;
import p007b.p225i.p226a.p242c.p267x2.p277l0.WavHeaderReader;
import p007b.p225i.p226a.p242c.p279z2.p283k.C3166a;
import p007b.p225i.p226a.p242c.p279z2.p283k.Id3Decoder;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.Predicate3;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AnimatableValueParser.java */
/* renamed from: b.c.a.a0.d, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableValueParser {

    /* renamed from: a */
    public static boolean f2216a;

    /* renamed from: b */
    public static ScheduledExecutorService f2217b;

    /* renamed from: c */
    @Nullable
    public static Boolean f2218c;

    /* renamed from: d */
    @Nullable
    public static Boolean f2219d;

    /* renamed from: e */
    @Nullable
    public static Boolean f2220e;

    /* renamed from: f */
    @Nullable
    public static Boolean f2221f;

    /* compiled from: ArrayBuilders.java */
    /* renamed from: b.c.a.a0.d$a */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        public final /* synthetic */ Class f2222a;

        /* renamed from: b */
        public final /* synthetic */ int f2223b;

        /* renamed from: c */
        public final /* synthetic */ Object f2224c;

        public a(Class cls, int i, Object obj) {
            this.f2222a = cls;
            this.f2223b = i;
            this.f2224c = obj;
        }

        public boolean equals(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
            if (obj == this) {
                return true;
            }
            if (!ClassUtil.m2183o(obj, this.f2222a) || Array.getLength(obj) != this.f2223b) {
                return false;
            }
            for (int i = 0; i < this.f2223b; i++) {
                Object obj2 = Array.get(this.f2224c, i);
                Object obj3 = Array.get(obj, i);
                if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    /* renamed from: A */
    public static <T> T m415A(@Nullable T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }

    /* renamed from: A0 */
    public static ScalingUtils$ScaleType m416A0(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
                return C1792z.f3450l;
            case 1:
                ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.f19495a;
                return C1790x.f3448l;
            case 2:
                ScalingUtils$ScaleType scalingUtils$ScaleType3 = ScalingUtils$ScaleType.f19495a;
                return C1788v.f3446l;
            case 3:
                ScalingUtils$ScaleType scalingUtils$ScaleType4 = ScalingUtils$ScaleType.f19495a;
                return C1789w.f3447l;
            case 4:
                ScalingUtils$ScaleType scalingUtils$ScaleType5 = ScalingUtils$ScaleType.f19495a;
                return C1784r.f3442l;
            case 5:
                ScalingUtils$ScaleType scalingUtils$ScaleType6 = ScalingUtils$ScaleType.f19495a;
                return C1786t.f3444l;
            case 6:
                ScalingUtils$ScaleType scalingUtils$ScaleType7 = ScalingUtils$ScaleType.f19495a;
                return C1785s.f3443l;
            case 7:
                ScalingUtils$ScaleType scalingUtils$ScaleType8 = ScalingUtils$ScaleType.f19495a;
                return C1763b0.f3334l;
            case 8:
                ScalingUtils$ScaleType scalingUtils$ScaleType9 = ScalingUtils$ScaleType.f19495a;
                return C1787u.f3445l;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    /* renamed from: A1 */
    public static boolean m417A1(TypeResolutionContext typeResolutionContext, JavaType javaType, Type type) {
        if (!javaType.m2216B(typeResolutionContext.mo1831a(type)._class)) {
            return false;
        }
        ParameterizedType parameterizedTypeM525h1 = m525h1(type);
        if (parameterizedTypeM525h1 == null || !Objects.equals(javaType._class, parameterizedTypeM525h1.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = parameterizedTypeM525h1.getActualTypeArguments();
        TypeBindings typeBindingsMo2136j = javaType.mo2136j();
        if (typeBindingsMo2136j.m2155j() != actualTypeArguments.length) {
            return false;
        }
        for (int i = 0; i < typeBindingsMo2136j.m2155j(); i++) {
            if (!m417A1(typeResolutionContext, typeBindingsMo2136j.m2151f(i), actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: A2 */
    public static void m418A2(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    /* renamed from: B */
    public static void m419B(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    @NonNull
    /* renamed from: B0 */
    public static String m420B0(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return outline.m851g(32, "unknown status code: ", i);
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }

    /* renamed from: B1 */
    public static int m421B1(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    /* renamed from: B2 */
    public static <T extends Parcelable> void m422B2(Parcel parcel, T t, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    /* renamed from: C */
    public static void m423C(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: C0 */
    public static String[] m424C0() {
        return Build.VERSION.SDK_INT >= 23 ? SysUtil$MarshmallowSysdeps.getSupportedAbis() : SysUtil$LollipopSysdeps.getSupportedAbis();
    }

    /* renamed from: C1 */
    public static void m425C1(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int i2;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (i2 = fileChannel.read(byteBuffer, j)) != -1) {
            j += i2;
        }
        if (byteBuffer.remaining() > 0) {
            throw new MinElf("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    @Pure
    /* renamed from: D */
    public static void m426D(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: D0 */
    public static String m427D0(String str) {
        return outline.m883w("TransportRuntime.", str);
    }

    /* renamed from: D1 */
    public static int m428D1(InputStream inputStream) throws IOException {
        byte b2 = (byte) (inputStream.read() & 255);
        return ((((byte) (inputStream.read() & 255)) << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((((byte) (inputStream.read() & 255)) << 8) & 65280) | (b2 & 255);
    }

    @Pure
    /* renamed from: E */
    public static void m429E(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: E0 */
    public static Pair<Integer, Integer> m430E0(InputStream inputStream) throws IOException {
        inputStream.skip(7L);
        short s2 = (short) (inputStream.read() & 255);
        short s3 = (short) (inputStream.read() & 255);
        short s4 = (short) (inputStream.read() & 255);
        if (s2 == 157 && s3 == 1 && s4 == 42) {
            return new Pair<>(Integer.valueOf(m548n0(inputStream)), Integer.valueOf(m548n0(inputStream)));
        }
        return null;
    }

    /* renamed from: E1 */
    public static boolean m431E1(@RecentlyNonNull Parcel parcel, int i) {
        m590x2(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: F */
    public static void m432F(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: F0 */
    public static Pair<Integer, Integer> m433F0(InputStream inputStream) throws IOException {
        m584w0(inputStream);
        if (((byte) (inputStream.read() & 255)) != 47) {
            return null;
        }
        int i = ((byte) inputStream.read()) & 255;
        int i2 = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf((i | ((i2 & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((i2 & Opcodes.CHECKCAST) >> 6)) + 1));
    }

    @RecentlyNonNull
    /* renamed from: F1 */
    public static IBinder m434F1(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return strongBinder;
    }

    /* renamed from: G */
    public static void m435G(boolean z2, @RecentlyNonNull Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: G0 */
    public static long m436G0(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        m425C1(fileChannel, byteBuffer, 4, j);
        return byteBuffer.getInt() & 4294967295L;
    }

    /* renamed from: G1 */
    public static int m437G1(@RecentlyNonNull Parcel parcel, int i) {
        m590x2(parcel, i, 4);
        return parcel.readInt();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    /* renamed from: H */
    public static <T> T m438H(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    /* renamed from: H0 */
    public static final boolean m439H0(Long l, long j) {
        return l != null && (l.longValue() & j) == j;
    }

    /* renamed from: H1 */
    public static long m440H1(@RecentlyNonNull Parcel parcel, int i) {
        m590x2(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: I */
    public static boolean m441I(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (str.charAt(i) != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: I0 */
    public static boolean m442I0(byte[] bArr, byte[] bArr2, int i) {
        Objects.requireNonNull(bArr);
        Objects.requireNonNull(bArr2);
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: I1 */
    public static int m443I1(ParsableByteArray parsableByteArray) {
        int i = 0;
        while (parsableByteArray.m3081a() != 0) {
            int iM3100t = parsableByteArray.m3100t();
            i += iM3100t;
            if (iM3100t != 255) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: J */
    public static void m444J(long j, ParsableByteArray parsableByteArray, TrackOutput2[] trackOutput2Arr) {
        while (true) {
            if (parsableByteArray.m3081a() <= 1) {
                return;
            }
            int iM443I1 = m443I1(parsableByteArray);
            int iM443I12 = m443I1(parsableByteArray);
            int i = parsableByteArray.f6794b + iM443I12;
            if (iM443I12 == -1 || iM443I12 > parsableByteArray.m3081a()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i = parsableByteArray.f6795c;
            } else if (iM443I1 == 4 && iM443I12 >= 8) {
                int iM3100t = parsableByteArray.m3100t();
                int iM3105y = parsableByteArray.m3105y();
                int iM3086f = iM3105y == 49 ? parsableByteArray.m3086f() : 0;
                int iM3100t2 = parsableByteArray.m3100t();
                if (iM3105y == 47) {
                    parsableByteArray.m3080F(1);
                }
                boolean z2 = iM3100t == 181 && (iM3105y == 49 || iM3105y == 47) && iM3100t2 == 3;
                if (iM3105y == 49) {
                    z2 &= iM3086f == 1195456820;
                }
                if (z2) {
                    m447K(j, parsableByteArray, trackOutput2Arr);
                }
            }
            parsableByteArray.m3079E(i);
        }
    }

    /* renamed from: J0 */
    public static int m445J0(int i, int i2) {
        return ((i + 31) * 31) + i2;
    }

    /* renamed from: J1 */
    public static int m446J1(InputStream inputStream, int i, boolean z2) throws IOException {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw new IOException("no more bytes");
            }
            if (z2) {
                i2 = (i5 & 255) << (i4 * 8);
            } else {
                i3 <<= 8;
                i2 = i5 & 255;
            }
            i3 |= i2;
        }
        return i3;
    }

    /* renamed from: K */
    public static void m447K(long j, ParsableByteArray parsableByteArray, TrackOutput2[] trackOutput2Arr) {
        int iM3100t = parsableByteArray.m3100t();
        if ((iM3100t & 64) != 0) {
            parsableByteArray.m3080F(1);
            int i = (iM3100t & 31) * 3;
            int i2 = parsableByteArray.f6794b;
            for (TrackOutput2 trackOutput2 : trackOutput2Arr) {
                parsableByteArray.m3079E(i2);
                trackOutput2.mo2524c(parsableByteArray, i);
                if (j != -9223372036854775807L) {
                    trackOutput2.mo2525d(j, 1, i, 0, null);
                }
            }
        }
    }

    /* renamed from: K0 */
    public static int m448K0(Object obj, Object obj2) {
        return m445J0(obj == null ? 0 : obj.hashCode(), obj2 != null ? obj2.hashCode() : 0);
    }

    /* renamed from: K1 */
    public static long m449K1(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.m3079E(i);
        if (parsableByteArray.m3081a() < 5) {
            return -9223372036854775807L;
        }
        int iM3086f = parsableByteArray.m3086f();
        if ((8388608 & iM3086f) != 0 || ((2096896 & iM3086f) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((iM3086f & 32) != 0) && parsableByteArray.m3100t() >= 7 && parsableByteArray.m3081a() >= 7) {
            if ((parsableByteArray.m3100t() & 16) == 16) {
                System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, new byte[6], 0, 6);
                parsableByteArray.f6794b += 6;
                return ((r0[0] & 255) << 25) | ((r0[1] & 255) << 17) | ((r0[2] & 255) << 9) | ((r0[3] & 255) << 1) | ((r0[4] & 255) >> 7);
            }
        }
        return -9223372036854775807L;
    }

    /* renamed from: L */
    public static void m450L(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    /* renamed from: L0 */
    public static void m451L0(String str, String str2) {
        Log.i(m427D0(str), str2);
    }

    /* renamed from: L1 */
    public static FlacStreamMetadata.a m452L1(ParsableByteArray parsableByteArray) {
        parsableByteArray.m3080F(1);
        int iM3102v = parsableByteArray.m3102v();
        long j = parsableByteArray.f6794b + iM3102v;
        int i = iM3102v / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long jM3093m = parsableByteArray.m3093m();
            if (jM3093m == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jM3093m;
            jArrCopyOf2[i2] = parsableByteArray.m3093m();
            parsableByteArray.m3080F(2);
            i2++;
        }
        parsableByteArray.m3080F((int) (j - parsableByteArray.f6794b));
        return new FlacStreamMetadata.a(jArrCopyOf, jArrCopyOf2);
    }

    @RecentlyNonNull
    /* renamed from: M */
    public static Bundle m453M(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return bundle;
    }

    /* renamed from: M0 */
    public static int m454M0(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    /* renamed from: M1 */
    public static int m455M1(@RecentlyNonNull Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    @RecentlyNonNull
    /* renamed from: N */
    public static byte[] m456N(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return bArrCreateByteArray;
    }

    /* renamed from: N0 */
    public static <T> DataSource<T> m457N0(Throwable th) {
        SimpleDataSource simpleDataSource = new SimpleDataSource();
        Objects.requireNonNull(th);
        simpleDataSource.m1027k(th, null);
        return simpleDataSource;
    }

    /* renamed from: N1 */
    public static VorbisUtil3 m458N1(ParsableByteArray parsableByteArray, boolean z2, boolean z3) throws ParserException {
        if (z2) {
            m550n2(3, parsableByteArray, false);
        }
        String strM3097q = parsableByteArray.m3097q((int) parsableByteArray.m3090j());
        int length = strM3097q.length() + 11;
        long jM3090j = parsableByteArray.m3090j();
        String[] strArr = new String[(int) jM3090j];
        int length2 = length + 4;
        for (int i = 0; i < jM3090j; i++) {
            strArr[i] = parsableByteArray.m3097q((int) parsableByteArray.m3090j());
            length2 = length2 + 4 + strArr[i].length();
        }
        if (z3 && (parsableByteArray.m3100t() & 1) == 0) {
            throw ParserException.m8755a("framing bit expected to be set", null);
        }
        return new VorbisUtil3(strM3097q, strArr, length2 + 1);
    }

    @RecentlyNonNull
    /* renamed from: O */
    public static int[] m459O(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return iArrCreateIntArray;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01cc A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ce A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01db A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dd A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e3 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0146  */
    /* renamed from: O0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m460O0(Map<String, List<String>> map) {
        char c;
        List<String> list = map.get("Content-Type");
        String str = (list == null || list.isEmpty()) ? null : list.get(0);
        if (str != null) {
            ArrayList<MimeTypes.a> arrayList = MimeTypes.f6749a;
            int iHashCode = str.hashCode();
            char c2 = 2;
            if (iHashCode == -1007807498) {
                if (str.equals("audio/x-flac")) {
                    c = 0;
                }
                if (c == 0) {
                }
                switch (str.hashCode()) {
                    case -2123537834:
                        break;
                    case -1662384011:
                        break;
                    case -1662384007:
                        break;
                    case -1662095187:
                        break;
                    case -1606874997:
                        break;
                    case -1487394660:
                        break;
                    case -1248337486:
                        break;
                    case -1004728940:
                        break;
                    case -387023398:
                        break;
                    case -43467528:
                        break;
                    case 13915911:
                        break;
                    case 187078296:
                        break;
                    case 187078297:
                        break;
                    case 187078669:
                        break;
                    case 187090232:
                        break;
                    case 187091926:
                        break;
                    case 187099443:
                        break;
                    case 1331848029:
                        break;
                    case 1503095341:
                        break;
                    case 1504578661:
                        break;
                    case 1504619009:
                        break;
                    case 1504831518:
                        break;
                    case 1505118770:
                        break;
                    case 2039520277:
                        break;
                }
                switch (c2) {
                }
            } else {
                if (iHashCode != -586683234) {
                    c = (iHashCode == 187090231 && str.equals("audio/mp3")) ? (char) 2 : (char) 65535;
                    if (c == 0) {
                        str = "audio/flac";
                    } else if (c == 1) {
                        str = "audio/wav";
                    } else if (c == 2) {
                        str = "audio/mpeg";
                    }
                    switch (str.hashCode()) {
                        case -2123537834:
                            c2 = !str.equals("audio/eac3-joc") ? (char) 65535 : (char) 0;
                            break;
                        case -1662384011:
                            if (str.equals("video/mp2p")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -1662384007:
                            if (!str.equals("video/mp2t")) {
                            }
                            break;
                        case -1662095187:
                            if (str.equals("video/webm")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -1606874997:
                            if (str.equals("audio/amr-wb")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case -1487394660:
                            if (str.equals("image/jpeg")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case -1248337486:
                            if (str.equals("application/mp4")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case -1004728940:
                            if (str.equals("text/vtt")) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case -387023398:
                            if (str.equals("audio/x-matroska")) {
                                c2 = '\b';
                                break;
                            }
                            break;
                        case -43467528:
                            if (str.equals("application/webm")) {
                                c2 = '\t';
                                break;
                            }
                            break;
                        case 13915911:
                            if (str.equals("video/x-flv")) {
                                c2 = '\n';
                                break;
                            }
                            break;
                        case 187078296:
                            if (str.equals("audio/ac3")) {
                                c2 = 11;
                                break;
                            }
                            break;
                        case 187078297:
                            if (str.equals("audio/ac4")) {
                                c2 = '\f';
                                break;
                            }
                            break;
                        case 187078669:
                            if (str.equals("audio/amr")) {
                                c2 = '\r';
                                break;
                            }
                            break;
                        case 187090232:
                            if (str.equals("audio/mp4")) {
                                c2 = 14;
                                break;
                            }
                            break;
                        case 187091926:
                            if (str.equals("audio/ogg")) {
                                c2 = 15;
                                break;
                            }
                            break;
                        case 187099443:
                            if (str.equals("audio/wav")) {
                                c2 = 16;
                                break;
                            }
                            break;
                        case 1331848029:
                            if (str.equals("video/mp4")) {
                                c2 = 17;
                                break;
                            }
                            break;
                        case 1503095341:
                            if (str.equals("audio/3gpp")) {
                                c2 = 18;
                                break;
                            }
                            break;
                        case 1504578661:
                            if (str.equals("audio/eac3")) {
                                c2 = 19;
                                break;
                            }
                            break;
                        case 1504619009:
                            if (str.equals("audio/flac")) {
                                c2 = 20;
                                break;
                            }
                            break;
                        case 1504831518:
                            if (str.equals("audio/mpeg")) {
                                c2 = 21;
                                break;
                            }
                            break;
                        case 1505118770:
                            if (str.equals("audio/webm")) {
                                c2 = 22;
                                break;
                            }
                            break;
                        case 2039520277:
                            if (str.equals("video/x-matroska")) {
                                c2 = 23;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 11:
                        case 19:
                            return 0;
                        case 1:
                            return 10;
                        case 2:
                            return 11;
                        case 3:
                        case '\b':
                        case '\t':
                        case 22:
                        case 23:
                            return 6;
                        case 4:
                        case '\r':
                        case 18:
                            return 3;
                        case 5:
                            return 14;
                        case 6:
                        case 14:
                        case 17:
                            return 8;
                        case 7:
                            return 13;
                        case '\n':
                            return 5;
                        case '\f':
                            return 1;
                        case 15:
                            return 9;
                        case 16:
                            return 12;
                        case 20:
                            return 4;
                        case 21:
                            return 7;
                    }
                }
                if (str.equals("audio/x-wav")) {
                    c = 1;
                }
                if (c == 0) {
                }
                switch (str.hashCode()) {
                    case -2123537834:
                        break;
                    case -1662384011:
                        break;
                    case -1662384007:
                        break;
                    case -1662095187:
                        break;
                    case -1606874997:
                        break;
                    case -1487394660:
                        break;
                    case -1248337486:
                        break;
                    case -1004728940:
                        break;
                    case -387023398:
                        break;
                    case -43467528:
                        break;
                    case 13915911:
                        break;
                    case 187078296:
                        break;
                    case 187078297:
                        break;
                    case 187078669:
                        break;
                    case 187090232:
                        break;
                    case 187091926:
                        break;
                    case 187099443:
                        break;
                    case 1331848029:
                        break;
                    case 1503095341:
                        break;
                    case 1504578661:
                        break;
                    case 1504619009:
                        break;
                    case 1504831518:
                        break;
                    case 1505118770:
                        break;
                    case 2039520277:
                        break;
                }
                switch (c2) {
                }
            }
        }
        return -1;
    }

    /* renamed from: O1 */
    public static void m461O1(Cue.b bVar) {
        bVar.f5783k = -3.4028235E38f;
        bVar.f5782j = Integer.MIN_VALUE;
        CharSequence charSequence = bVar.f5773a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                bVar.f5773a = SpannableString.valueOf(charSequence);
            }
            CharSequence charSequence2 = bVar.f5773a;
            Objects.requireNonNull(charSequence2);
            m464P1((Spannable) charSequence2, C2664h.f6342a);
        }
    }

    /* renamed from: P */
    public static final MediaSource m462P(MediaType mediaType, String str, String str2) {
        Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics3.checkNotNullParameter(str, "progressiveMediaUri");
        Intrinsics3.checkNotNullParameter(str2, "featureTag");
        Uri uri = Uri.parse(str);
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(progressiveMediaUri)");
        return new MediaSource(uri, str2, mediaType);
    }

    /* renamed from: P0 */
    public static int m463P0(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        return (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) ? 14 : -1;
    }

    /* renamed from: P1 */
    public static void m464P1(Spannable spannable, Predicate3<Object> predicate3) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (predicate3.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    @RecentlyNonNull
    /* renamed from: Q */
    public static <T extends Parcelable> T m465Q(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iM455M1);
        return tCreateFromParcel;
    }

    /* renamed from: Q0 */
    public static void m466Q0(String str) {
        throw new IllegalArgumentException(outline.m883w("Unknown library: ", str));
    }

    /* renamed from: Q1 */
    public static void m467Q1(File file, File file2) throws FileUtils$RenameException {
        Objects.requireNonNull(file);
        file2.delete();
        if (file.renameTo(file2)) {
            return;
        }
        Throwable fileUtils$FileDeleteException = null;
        if (file2.exists()) {
            fileUtils$FileDeleteException = new FileUtils$FileDeleteException(file2.getAbsolutePath());
        } else if (!file.getParentFile().exists()) {
            fileUtils$FileDeleteException = new FileUtils$ParentDirNotFoundException(file.getAbsolutePath());
        } else if (!file.exists()) {
            fileUtils$FileDeleteException = new FileNotFoundException(file.getAbsolutePath());
        }
        StringBuilder sbM833U = outline.m833U("Unknown error renaming ");
        sbM833U.append(file.getAbsolutePath());
        sbM833U.append(" to ");
        sbM833U.append(file2.getAbsolutePath());
        throw new FileUtils$RenameException(sbM833U.toString(), fileUtils$FileDeleteException);
    }

    @RecentlyNonNull
    /* renamed from: R */
    public static String m468R(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return string;
    }

    /* renamed from: R0 */
    public static boolean m469R0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(str);
    }

    /* renamed from: R1 */
    public static final RenderContext m470R1(Function1<? super RenderContext, Unit> function1, Object... objArr) {
        Intrinsics3.checkNotNullParameter(function1, "init");
        Intrinsics3.checkNotNullParameter(objArr, "orderedArguments");
        RenderContext renderContext = new RenderContext();
        function1.invoke(renderContext);
        if (!(objArr.length == 0)) {
            if (!renderContext.args.isEmpty()) {
                throw new IllegalArgumentException("must provide named arguments OR formatArgs, not both.");
            }
            renderContext.orderedArguments = _Arrays.toList(objArr);
        }
        return renderContext;
    }

    @RecentlyNonNull
    /* renamed from: S */
    public static String[] m471S(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return strArrCreateStringArray;
    }

    /* renamed from: S0 */
    public static boolean m472S0(int i, int i2, ResizeOptions resizeOptions) {
        return resizeOptions == null ? ((float) m552o0(i)) >= 2048.0f && m552o0(i2) >= 2048 : m552o0(i) >= resizeOptions.f3717a && m552o0(i2) >= resizeOptions.f3718b;
    }

    /* renamed from: S1 */
    public static /* synthetic */ void m473S1(AppPermissions2 appPermissions2, Function0 function0, Function0 function02, int i, Object obj) {
        int i2 = i & 1;
        appPermissions2.requestMicrophone(null, function02);
    }

    @RecentlyNonNull
    /* renamed from: T */
    public static ArrayList<String> m474T(@RecentlyNonNull Parcel parcel, int i) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iM455M1);
        return arrayListCreateStringArrayList;
    }

    /* renamed from: T0 */
    public static boolean m475T0(EncodedImage2 encodedImage2, ResizeOptions resizeOptions) {
        if (encodedImage2 == null) {
            return false;
        }
        encodedImage2.m1347x();
        int i = encodedImage2.f3894m;
        if (i == 90 || i == 270) {
            encodedImage2.m1347x();
            int i2 = encodedImage2.f3897p;
            encodedImage2.m1347x();
            return m472S0(i2, encodedImage2.f3896o, resizeOptions);
        }
        encodedImage2.m1347x();
        int i3 = encodedImage2.f3896o;
        encodedImage2.m1347x();
        return m472S0(i3, encodedImage2.f3897p, resizeOptions);
    }

    @Nullable
    /* renamed from: T1 */
    public static TtmlStyle m476T1(@Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, Map<String, TtmlStyle> map) {
        int i = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i < length) {
                    ttmlStyle2.m2701a(map.get(strArr[i]));
                    i++;
                }
                return ttmlStyle2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                ttmlStyle.m2701a(map.get(strArr[0]));
                return ttmlStyle;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    ttmlStyle.m2701a(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return ttmlStyle;
    }

    @RecentlyNonNull
    /* renamed from: U */
    public static <T> T[] m477U(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iM455M1);
        return tArr;
    }

    /* renamed from: U0 */
    public static final boolean m478U0(Context context) {
        Intrinsics3.checkNotNullParameter(context, "$this$isLtr");
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 0;
    }

    /* renamed from: U1 */
    public static float m479U1(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f2 = i2;
        }
        return f * f2;
    }

    @RecentlyNonNull
    /* renamed from: V */
    public static <T> ArrayList<T> m480V(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM455M1 == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iM455M1);
        return arrayListCreateTypedArrayList;
    }

    /* renamed from: V0 */
    public static final boolean m481V0(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "$this$isMutedByAnySource");
        return voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [TResult, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [TInput, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [b.i.a.b.i.b, b.i.a.b.i.b<TInput, TResult, TException extends java.lang.Throwable>] */
    /* renamed from: V1 */
    public static <TInput, TResult, TException extends Throwable> TResult m482V1(int i, TInput tinput, CctTransportBackend<TInput, TResult, TException> cctTransportBackend, RetryStrategy<TInput, TResult> retryStrategy) throws Throwable {
        ?? r0;
        if (i < 1) {
            return (TResult) cctTransportBackend.m2295a(tinput);
        }
        do {
            r0 = (TResult) cctTransportBackend.m2295a(tinput);
            CctTransportBackend3.a aVar = (CctTransportBackend3.a) tinput;
            CctTransportBackend3.b bVar = (CctTransportBackend3.b) r0;
            URL url = bVar.f5143b;
            if (url != null) {
                m486X("CctTransportBackend", "Following redirect to: %s", url);
                tinput = (TInput) new CctTransportBackend3.a(bVar.f5143b, aVar.f5140b, aVar.f5141c);
            } else {
                tinput = 0;
            }
            if (tinput == 0) {
                break;
            }
            i--;
        } while (i >= 1);
        return r0;
    }

    /* renamed from: W */
    public static String m483W(String str) {
        StringBuilder sbM831S = outline.m831S(outline.m841b(str, outline.m841b(str, 5)), ".", str, ",.", str);
        sbM831S.append(" *");
        return sbM831S.toString();
    }

    /* renamed from: W0 */
    public static final boolean m484W0(StageInstance stageInstance) {
        Intrinsics3.checkNotNullParameter(stageInstance, "$this$isPublic");
        return stageInstance.getPrivacyLevel() == StageInstancePrivacyLevel.PUBLIC;
    }

    /* renamed from: W1 */
    public static String m485W1(CacheKey cacheKey) throws UnsupportedEncodingException {
        byte[] bytes = cacheKey.mo930b().getBytes(Constants.ENCODING);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            messageDigest.update(bytes, 0, bytes.length);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: X */
    public static void m486X(String str, String str2, Object obj) {
        Log.d(m427D0(str), String.format(str2, obj));
    }

    /* renamed from: X0 */
    public static final boolean m487X0(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "$this$isRemoveSignal");
        return voiceState.getChannelId() == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: X1 */
    public static void m488X1(Drawable drawable, Drawable.Callback callback, TransformCallback transformCallback) {
        if (drawable != 0) {
            drawable.setCallback(callback);
            if (drawable instanceof TransformAwareDrawable) {
                ((TransformAwareDrawable) drawable).mo1094b(transformCallback);
            }
        }
    }

    /* renamed from: Y */
    public static void m489Y(String str, String str2, Object... objArr) {
        Log.d(m427D0(str), String.format(str2, objArr));
    }

    /* renamed from: Y0 */
    public static boolean m490Y0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 2) && xmlPullParser.getName().equals(str);
    }

    /* renamed from: Y1 */
    public static void m491Y1(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(outline.m851g(15, "csd-", i), ByteBuffer.wrap(list.get(i)));
        }
    }

    /* renamed from: Z */
    public static boolean m492Z(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m492Z(file2);
            }
        }
        return file.delete();
    }

    @TargetApi(20)
    /* renamed from: Z0 */
    public static boolean m493Z0(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f2218c == null) {
            f2218c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f2218c.booleanValue();
    }

    /* renamed from: Z1 */
    public static void m494Z1(Drawable drawable, DrawableProperties drawableProperties) {
        if (drawable == null || drawableProperties == null) {
            return;
        }
        int i = drawableProperties.f3339a;
        if (i != -1) {
            drawable.setAlpha(i);
        }
        if (drawableProperties.f3340b) {
            drawable.setColorFilter(drawableProperties.f3341c);
        }
        int i2 = drawableProperties.f3342d;
        if (i2 != -1) {
            drawable.setDither(i2 != 0);
        }
        int i3 = drawableProperties.f3343e;
        if (i3 != -1) {
            drawable.setFilterBitmap(i3 != 0);
        }
    }

    /* renamed from: a */
    public static float m495a(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    /* renamed from: a0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m496a0(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage2 encodedImage2, int i) {
        float fMax;
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        if (!EncodedImage2.m1337s(encodedImage2)) {
            return 1;
        }
        m527i(Boolean.valueOf(EncodedImage2.m1337s(encodedImage2)));
        if (resizeOptions == null || resizeOptions.f3718b <= 0 || resizeOptions.f3717a <= 0) {
            fMax = 1.0f;
        } else {
            encodedImage2.m1347x();
            if (encodedImage2.f3896o != 0) {
                encodedImage2.m1347x();
                if (encodedImage2.f3897p != 0) {
                    if (rotationOptions.m1251c()) {
                        encodedImage2.m1347x();
                        i2 = encodedImage2.f3894m;
                        m527i(Boolean.valueOf(i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270));
                    } else {
                        i2 = 0;
                    }
                    boolean z2 = i2 == 90 || i2 == 270;
                    if (z2) {
                        encodedImage2.m1347x();
                        i3 = encodedImage2.f3897p;
                    } else {
                        encodedImage2.m1347x();
                        i3 = encodedImage2.f3896o;
                    }
                    if (z2) {
                        encodedImage2.m1347x();
                        i4 = encodedImage2.f3896o;
                    } else {
                        encodedImage2.m1347x();
                        i4 = encodedImage2.f3897p;
                    }
                    fMax = Math.max(resizeOptions.f3717a / i3, resizeOptions.f3718b / i4);
                    int i6 = FLog.f3102a;
                }
            }
        }
        encodedImage2.m1347x();
        int i7 = 2;
        if (encodedImage2.f3893l == DefaultImageFormats.f3585a) {
            if (fMax <= 0.6666667f) {
                i5 = 2;
                while (true) {
                    int i8 = i5 * 2;
                    double d = 1.0d / i8;
                    if ((d * 0.3333333432674408d) + d <= fMax) {
                        break;
                    }
                    i5 = i8;
                }
            }
        } else if (fMax <= 0.6666667f) {
            while (true) {
                double d2 = i7;
                if (((1.0d / (Math.pow(d2, 2.0d) - d2)) * 0.3333333432674408d) + (1.0d / d2) <= fMax) {
                    break;
                }
                i7++;
            }
            i5 = i7 - 1;
        }
        encodedImage2.m1347x();
        int i9 = encodedImage2.f3897p;
        encodedImage2.m1347x();
        int iMax = Math.max(i9, encodedImage2.f3896o);
        float f = resizeOptions != null ? resizeOptions.f3719c : i;
        while (iMax / i5 > f) {
            encodedImage2.m1347x();
            i5 = encodedImage2.f3893l == DefaultImageFormats.f3585a ? i5 * 2 : i5 + 1;
        }
        return i5;
    }

    @TargetApi(26)
    /* renamed from: a1 */
    public static boolean m497a1(@RecentlyNonNull Context context) {
        if (!m493Z0(context)) {
            return false;
        }
        if (!(Build.VERSION.SDK_INT >= 24)) {
            return true;
        }
        if (f2219d == null) {
            f2219d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f2219d.booleanValue() && !C3404f.m4190A0();
    }

    /* renamed from: a2 */
    public static <TResult> void m498a2(Status status, @Nullable TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.m9030w0()) {
            taskCompletionSource.f20845a.m6024s(tresult);
        } else {
            taskCompletionSource.f20845a.m6025t(new ApiException(status));
        }
    }

    /* renamed from: b */
    public static float m499b(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* renamed from: b0 */
    public static void m500b0(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                m500b0(file2);
            }
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            Log.e("SysUtil", "Enable write permission failed: " + parentFile);
        }
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("Could not delete file " + file);
    }

    /* renamed from: b1 */
    public static final void m501b1(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.d$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    /* renamed from: b2 */
    public static boolean m502b2(Object obj, Collection<String> collection, Collection<String> collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        return collection2 == null ? collection.contains(obj) : collection == null ? !collection2.contains(obj) : !collection2.contains(obj) || collection.contains(obj);
    }

    /* renamed from: c */
    public static void m503c(Spannable spannable, Object obj, int i, int i2, int i3) {
        for (Object obj2 : spannable.getSpans(i, i2, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i && spannable.getSpanEnd(obj2) == i2 && spannable.getSpanFlags(obj2) == i3) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i, i2, i3);
    }

    /* renamed from: c0 */
    public static void m504c0(String str, String str2, Throwable th) {
        Log.e(m427D0(str), str2, th);
    }

    /* renamed from: c1 */
    public static final void m505c1(String str, String str2, Throwable th) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.e$default(LoggingProvider.INSTANCE.get(), str, str2, th, null, 8, null);
    }

    /* renamed from: c2 */
    public static long m506c2(InputStream inputStream, long j) throws IOException {
        m527i(Boolean.valueOf(j >= 0));
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    return j - j2;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j;
    }

    /* renamed from: d */
    public static int m507d(int i, int i2, int i3) {
        return Math.min(Math.max(0, i3 - i), i2);
    }

    /* renamed from: d0 */
    public static void m508d0() {
        if (Util2.f6708a >= 18) {
            Trace.endSection();
        }
    }

    /* renamed from: d1 */
    public static final void m509d1(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.i$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    /* renamed from: d2 */
    public static void m510d2(@RecentlyNonNull Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + m455M1(parcel, i));
    }

    /* renamed from: e */
    public static byte[] m511e(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    /* renamed from: e0 */
    public static synchronized void m512e0() {
        if (!f2216a) {
            NativeLoader.m1589c("native-imagetranscoder");
            f2216a = true;
        }
    }

    /* renamed from: e1 */
    public static final void m513e1(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.v$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    /* renamed from: e2 */
    public static final <P extends Parcelable> Bundle m514e2(P p) {
        Intrinsics3.checkNotNullParameter(p, "$this$toBundle");
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent_args_key", p);
        return bundle;
    }

    /* renamed from: f */
    public static void m515f(String str) {
        if (Util2.f6708a >= 18) {
            Trace.beginSection(str);
        }
    }

    /* renamed from: f0 */
    public static void m516f0(@RecentlyNonNull Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new SafeParcelReader$ParseException(outline.m851g(37, "Overread allowed size end=", i), parcel);
        }
    }

    /* renamed from: f1 */
    public static final void m517f1(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.w$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    /* renamed from: f2 */
    public static String m518f2(@ColorInt int i) {
        return Util2.m3003k("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }

    /* renamed from: g */
    public static List<byte[]> m519g(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(m523h(((((bArr[11] & 255) << 8) | (bArr[10] & 255)) * 1000000000) / 48000));
        arrayList.add(m523h(80000000L));
        return arrayList;
    }

    /* renamed from: g0 */
    public static boolean m520g0(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: g1 */
    public static boolean m521g1(BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        return false;
    }

    /* renamed from: g2 */
    public static final <P extends Parcelable> Intent m522g2(P p) {
        Intrinsics3.checkNotNullParameter(p, "$this$toIntent");
        Intent intentPutExtra = new Intent().putExtra("intent_args_key", p);
        Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_ARGS, this)");
        return intentPutExtra;
    }

    /* renamed from: h */
    public static byte[] m523h(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    /* renamed from: h0 */
    public static boolean m524h0(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: h1 */
    public static ParameterizedType m525h1(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return m525h1(upperBounds[0]);
            }
        }
        return null;
    }

    /* renamed from: h2 */
    public static Objects2 m526h2(Object obj) {
        return new Objects2(obj.getClass().getSimpleName(), null);
    }

    /* renamed from: i */
    public static void m527i(Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: i0 */
    public static int m528i0(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float fM495a = m495a(((i >> 16) & 255) / 255.0f);
        float fM495a2 = m495a(((i >> 8) & 255) / 255.0f);
        float fM495a3 = m495a((i & 255) / 255.0f);
        float fM495a4 = m495a(((i2 >> 16) & 255) / 255.0f);
        float fM495a5 = m495a(((i2 >> 8) & 255) / 255.0f);
        float fM495a6 = m495a((i2 & 255) / 255.0f);
        float fM839a = outline.m839a(f3, f2, f, f2);
        float fM839a2 = outline.m839a(fM495a4, fM495a, f, fM495a);
        float fM839a3 = outline.m839a(fM495a5, fM495a2, f, fM495a2);
        float fM839a4 = outline.m839a(fM495a6, fM495a3, f, fM495a3);
        float fM499b = m499b(fM839a2) * 255.0f;
        float fM499b2 = m499b(fM839a3) * 255.0f;
        return Math.round(m499b(fM839a4) * 255.0f) | (Math.round(fM499b) << 16) | (Math.round(fM839a * 255.0f) << 24) | (Math.round(fM499b2) << 8);
    }

    /* renamed from: i1 */
    public static TypeVariable<?> m529i1(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return m529i1(upperBounds[0]);
            }
        }
        return null;
    }

    /* renamed from: i2 */
    public static void m530i2(Collection<? extends Node> collection, NodeProcessor nodeProcessor) {
        Iterator<? extends Node> it = collection.iterator();
        while (it.hasNext()) {
            m534j2(it.next(), nodeProcessor);
        }
    }

    @Pure
    /* renamed from: j */
    public static void m531j(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: j0 */
    public static String[] m532j0(FileChannel fileChannel) throws IOException {
        long jM436G0;
        long jM436G02;
        long jM436G03;
        long j;
        long jM436G04;
        long j2;
        long jM436G05;
        long j3;
        long jM436G06;
        long j4;
        long jM436G07;
        long jM436G08;
        long jM436G09;
        long jM436G010;
        int i = 8;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jM436G011 = m436G0(fileChannel, byteBufferAllocate, 0L);
        if (jM436G011 != 1179403647) {
            StringBuilder sbM833U = outline.m833U("file is not ELF: 0x");
            sbM833U.append(Long.toHexString(jM436G011));
            throw new MinElf(sbM833U.toString());
        }
        m425C1(fileChannel, byteBufferAllocate, 1, 4L);
        boolean z2 = ((short) (byteBufferAllocate.get() & 255)) == 1;
        m425C1(fileChannel, byteBufferAllocate, 1, 5L);
        if (((short) (byteBufferAllocate.get() & 255)) == 2) {
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        }
        if (z2) {
            jM436G0 = m436G0(fileChannel, byteBufferAllocate, 28L);
        } else {
            m425C1(fileChannel, byteBufferAllocate, 8, 32L);
            jM436G0 = byteBufferAllocate.getLong();
        }
        m425C1(fileChannel, byteBufferAllocate, 2, z2 ? 44L : 56L);
        long jM436G012 = byteBufferAllocate.getShort() & 65535;
        m425C1(fileChannel, byteBufferAllocate, 2, z2 ? 42L : 54L);
        int i2 = 65535 & byteBufferAllocate.getShort();
        if (jM436G012 == 65535) {
            if (z2) {
                jM436G010 = m436G0(fileChannel, byteBufferAllocate, 32L);
            } else {
                m425C1(fileChannel, byteBufferAllocate, 8, 40L);
                jM436G010 = byteBufferAllocate.getLong();
            }
            jM436G012 = z2 ? m436G0(fileChannel, byteBufferAllocate, jM436G010 + 28) : m436G0(fileChannel, byteBufferAllocate, jM436G010 + 44);
        }
        long j5 = 0;
        long j6 = jM436G0;
        while (true) {
            if (j5 >= jM436G012) {
                jM436G02 = 0;
                break;
            }
            if ((z2 ? m436G0(fileChannel, byteBufferAllocate, j6 + 0) : m436G0(fileChannel, byteBufferAllocate, 0 + j6)) != 2) {
                j6 += i2;
                j5++;
            } else if (z2) {
                jM436G02 = m436G0(fileChannel, byteBufferAllocate, j6 + 4);
            } else {
                m425C1(fileChannel, byteBufferAllocate, 8, j6 + 8);
                jM436G02 = byteBufferAllocate.getLong();
            }
        }
        long j7 = 0;
        if (jM436G02 == 0) {
            throw new MinElf("ELF file does not contain dynamic linking information");
        }
        int i3 = 0;
        long j8 = jM436G02;
        long j9 = 0;
        while (true) {
            long j10 = j8 + j7;
            if (z2) {
                jM436G03 = m436G0(fileChannel, byteBufferAllocate, j10);
            } else {
                m425C1(fileChannel, byteBufferAllocate, i, j10);
                jM436G03 = byteBufferAllocate.getLong();
            }
            if (jM436G03 == 1) {
                j = jM436G02;
                if (i3 == Integer.MAX_VALUE) {
                    throw new MinElf("malformed DT_NEEDED section");
                }
                i3++;
            } else {
                j = jM436G02;
                if (jM436G03 == 5) {
                    if (z2) {
                        jM436G04 = m436G0(fileChannel, byteBufferAllocate, j8 + 4);
                    } else {
                        m425C1(fileChannel, byteBufferAllocate, 8, j8 + 8);
                        jM436G04 = byteBufferAllocate.getLong();
                    }
                    j9 = jM436G04;
                }
            }
            long j11 = 16;
            j8 += z2 ? 8L : 16L;
            long j12 = 0;
            if (jM436G03 != 0) {
                i = 8;
                jM436G02 = j;
                j7 = 0;
            } else {
                if (j9 == 0) {
                    throw new MinElf("Dynamic section string-table not found");
                }
                int i4 = 0;
                int i5 = i3;
                while (true) {
                    if (i4 >= jM436G012) {
                        j2 = 0;
                        break;
                    }
                    if ((z2 ? m436G0(fileChannel, byteBufferAllocate, jM436G0 + j12) : m436G0(fileChannel, byteBufferAllocate, jM436G0 + j12)) == 1) {
                        if (z2) {
                            jM436G07 = m436G0(fileChannel, byteBufferAllocate, jM436G0 + 8);
                        } else {
                            m425C1(fileChannel, byteBufferAllocate, 8, j11 + jM436G0);
                            jM436G07 = byteBufferAllocate.getLong();
                        }
                        if (z2) {
                            jM436G08 = m436G0(fileChannel, byteBufferAllocate, 20 + jM436G0);
                            j4 = jM436G012;
                        } else {
                            j4 = jM436G012;
                            m425C1(fileChannel, byteBufferAllocate, 8, 40 + jM436G0);
                            jM436G08 = byteBufferAllocate.getLong();
                        }
                        if (jM436G07 <= j9 && j9 < jM436G08 + jM436G07) {
                            if (z2) {
                                jM436G09 = m436G0(fileChannel, byteBufferAllocate, jM436G0 + 4);
                            } else {
                                m425C1(fileChannel, byteBufferAllocate, 8, jM436G0 + 8);
                                jM436G09 = byteBufferAllocate.getLong();
                            }
                            j2 = (j9 - jM436G07) + jM436G09;
                        }
                    } else {
                        j4 = jM436G012;
                    }
                    jM436G0 += i2;
                    i4++;
                    j11 = 16;
                    j12 = 0;
                    jM436G012 = j4;
                }
                if (j2 == 0) {
                    throw new MinElf("did not find file offset of DT_STRTAB table");
                }
                String[] strArr = new String[i5];
                long j13 = 0;
                long j14 = j;
                int i6 = 0;
                while (true) {
                    long j15 = j13 + j14;
                    if (z2) {
                        jM436G05 = m436G0(fileChannel, byteBufferAllocate, j15);
                    } else {
                        m425C1(fileChannel, byteBufferAllocate, 8, j15);
                        jM436G05 = byteBufferAllocate.getLong();
                    }
                    if (jM436G05 == 1) {
                        if (z2) {
                            jM436G06 = m436G0(fileChannel, byteBufferAllocate, 4 + j14);
                        } else {
                            m425C1(fileChannel, byteBufferAllocate, 8, j14 + 8);
                            jM436G06 = byteBufferAllocate.getLong();
                        }
                        long j16 = jM436G06 + j2;
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            long j17 = j16 + 1;
                            j3 = j2;
                            m425C1(fileChannel, byteBufferAllocate, 1, j16);
                            short s2 = (short) (byteBufferAllocate.get() & 255);
                            if (s2 == 0) {
                                break;
                            }
                            sb.append((char) s2);
                            j16 = j17;
                            j2 = j3;
                        }
                        strArr[i6] = sb.toString();
                        if (i6 == Integer.MAX_VALUE) {
                            throw new MinElf("malformed DT_NEEDED section");
                        }
                        i6++;
                    } else {
                        j3 = j2;
                    }
                    j14 += z2 ? 8L : 16L;
                    if (jM436G05 == 0) {
                        if (i6 == i5) {
                            return strArr;
                        }
                        throw new MinElf("malformed DT_NEEDED section");
                    }
                    j13 = 0;
                    j2 = j3;
                }
            }
        }
    }

    /* renamed from: j1 */
    public static void m533j1(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    /* renamed from: j2 */
    public static void m534j2(Node node, NodeProcessor nodeProcessor) {
        if (node.hasChildren()) {
            Iterator it = node.getChildren().iterator();
            while (it.hasNext()) {
                m534j2((Node) it.next(), nodeProcessor);
            }
        }
        nodeProcessor.processNode(node);
    }

    /* renamed from: k */
    public static void m535k(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: k0 */
    public static String m536k0(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i2)) != -1) {
            sb.append(strValueOf.substring(i2, iIndexOf));
            sb.append(objArr[i]);
            i2 = iIndexOf + 2;
            i++;
        }
        sb.append(strValueOf.substring(i2));
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i3 = i + 1; i3 < objArr.length; i3++) {
                sb.append(", ");
                sb.append(objArr[i3]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    /* renamed from: k1 */
    public static String m537k1(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    /* renamed from: k2 */
    public static void m538k2(Node node, NodeProcessor nodeProcessor) {
        nodeProcessor.processNode(node);
        if (node.hasChildren()) {
            Iterator it = node.getChildren().iterator();
            while (it.hasNext()) {
                m538k2((Node) it.next(), nodeProcessor);
            }
        }
    }

    /* renamed from: l */
    public static void m539l(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @NonNull
    /* renamed from: l0 */
    public static ApiException m540l0(@NonNull Status status) {
        return status.f20497r != null ? new ResolvableApiException(status) : new ApiException(status);
    }

    /* renamed from: l1 */
    public static void m541l1(File file) throws FileUtils$CreateDirectoryException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!file.delete()) {
                throw new FileUtils$CreateDirectoryException(file.getAbsolutePath(), new FileUtils$FileDeleteException(file.getAbsolutePath()));
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new FileUtils$CreateDirectoryException(file.getAbsolutePath());
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0266 A[PHI: r1 r2 r3
      0x0266: PHI (r1v20 boolean) = (r1v15 boolean), (r1v22 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0266: PHI (r2v17 boolean) = (r2v12 boolean), (r2v19 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0266: PHI (r3v10 boolean) = (r3v6 boolean), (r3v12 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0268 A[PHI: r1 r2 r3
      0x0268: PHI (r1v17 boolean) = (r1v15 boolean), (r1v15 boolean), (r1v22 boolean), (r1v22 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r2v14 boolean) = (r2v12 boolean), (r2v12 boolean), (r2v19 boolean), (r2v19 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r3v8 boolean) = (r3v6 boolean), (r3v6 boolean), (r3v12 boolean), (r3v12 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: l2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GenericDraweeHierarchyBuilder m542l2(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int integer;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        boolean z9;
        int i3;
        boolean z10;
        Context context2 = context;
        int i4 = 1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C10638R.a.GenericDraweeHierarchy);
            try {
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                int i5 = 0;
                int dimensionPixelSize = 0;
                integer = 0;
                boolean z11 = true;
                boolean z12 = true;
                boolean z13 = true;
                boolean z14 = true;
                boolean z15 = true;
                boolean z16 = true;
                boolean z17 = true;
                boolean z18 = true;
                while (i5 < indexCount) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i5);
                    if (index == C10638R.a.GenericDraweeHierarchy_actualImageScaleType) {
                        genericDraweeHierarchyBuilder.f3464n = m416A0(typedArrayObtainStyledAttributes, index);
                    } else if (index == C10638R.a.GenericDraweeHierarchy_placeholderImage) {
                        genericDraweeHierarchyBuilder.f3456f = m576u0(context2, typedArrayObtainStyledAttributes, index);
                    } else {
                        if (index == C10638R.a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                            Drawable drawableM576u0 = m576u0(context2, typedArrayObtainStyledAttributes, index);
                            if (drawableM576u0 == null) {
                                genericDraweeHierarchyBuilder.f3467q = null;
                            } else {
                                StateListDrawable stateListDrawable = new StateListDrawable();
                                i2 = indexCount;
                                int[] iArr = new int[i4];
                                iArr[0] = 16842919;
                                stateListDrawable.addState(iArr, drawableM576u0);
                                genericDraweeHierarchyBuilder.f3467q = stateListDrawable;
                            }
                        } else {
                            i2 = indexCount;
                            if (index == C10638R.a.GenericDraweeHierarchy_progressBarImage) {
                                genericDraweeHierarchyBuilder.f3462l = m576u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_fadeDuration) {
                                genericDraweeHierarchyBuilder.f3454d = typedArrayObtainStyledAttributes.getInt(index, 0);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_viewAspectRatio) {
                                genericDraweeHierarchyBuilder.f3455e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_placeholderImageScaleType) {
                                genericDraweeHierarchyBuilder.f3457g = m416A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_retryImage) {
                                genericDraweeHierarchyBuilder.f3458h = m576u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_retryImageScaleType) {
                                genericDraweeHierarchyBuilder.f3459i = m416A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_failureImage) {
                                genericDraweeHierarchyBuilder.f3460j = m576u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_failureImageScaleType) {
                                genericDraweeHierarchyBuilder.f3461k = m416A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == C10638R.a.GenericDraweeHierarchy_progressBarImageScaleType) {
                                genericDraweeHierarchyBuilder.f3463m = m416A0(typedArrayObtainStyledAttributes, index);
                            } else {
                                if (index == C10638R.a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                                    integer = typedArrayObtainStyledAttributes.getInteger(index, integer);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_backgroundImage) {
                                    genericDraweeHierarchyBuilder.f3465o = m576u0(context2, typedArrayObtainStyledAttributes, index);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_overlayImage) {
                                    genericDraweeHierarchyBuilder.m1123b(m576u0(context2, typedArrayObtainStyledAttributes, index));
                                } else if (index == C10638R.a.GenericDraweeHierarchy_roundAsCircle) {
                                    if (genericDraweeHierarchyBuilder.f3468r == null) {
                                        genericDraweeHierarchyBuilder.f3468r = new RoundingParams();
                                    }
                                    genericDraweeHierarchyBuilder.f3468r.f3472b = typedArrayObtainStyledAttributes.getBoolean(index, false);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_roundedCornerRadius) {
                                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_roundTopLeft) {
                                    z11 = typedArrayObtainStyledAttributes.getBoolean(index, z11);
                                } else if (index == C10638R.a.GenericDraweeHierarchy_roundTopRight) {
                                    z14 = typedArrayObtainStyledAttributes.getBoolean(index, z14);
                                } else {
                                    if (index == C10638R.a.GenericDraweeHierarchy_roundBottomLeft) {
                                        z8 = typedArrayObtainStyledAttributes.getBoolean(index, z18);
                                    } else {
                                        z8 = z18;
                                        if (index == C10638R.a.GenericDraweeHierarchy_roundBottomRight) {
                                            z15 = typedArrayObtainStyledAttributes.getBoolean(index, z15);
                                        } else if (index == C10638R.a.GenericDraweeHierarchy_roundTopStart) {
                                            z12 = typedArrayObtainStyledAttributes.getBoolean(index, z12);
                                        } else if (index == C10638R.a.GenericDraweeHierarchy_roundTopEnd) {
                                            z13 = typedArrayObtainStyledAttributes.getBoolean(index, z13);
                                        } else {
                                            if (index == C10638R.a.GenericDraweeHierarchy_roundBottomStart) {
                                                z9 = typedArrayObtainStyledAttributes.getBoolean(index, z17);
                                            } else {
                                                z9 = z17;
                                                if (index == C10638R.a.GenericDraweeHierarchy_roundBottomEnd) {
                                                    z16 = typedArrayObtainStyledAttributes.getBoolean(index, z16);
                                                } else if (index == C10638R.a.GenericDraweeHierarchy_roundWithOverlayColor) {
                                                    if (genericDraweeHierarchyBuilder.f3468r == null) {
                                                        genericDraweeHierarchyBuilder.f3468r = new RoundingParams();
                                                    }
                                                    genericDraweeHierarchyBuilder.f3468r.m1125b(typedArrayObtainStyledAttributes.getColor(index, 0));
                                                } else {
                                                    if (index == C10638R.a.GenericDraweeHierarchy_roundingBorderWidth) {
                                                        if (genericDraweeHierarchyBuilder.f3468r == null) {
                                                            genericDraweeHierarchyBuilder.f3468r = new RoundingParams();
                                                        }
                                                        RoundingParams roundingParams = genericDraweeHierarchyBuilder.f3468r;
                                                        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                        Objects.requireNonNull(roundingParams);
                                                        if (dimensionPixelSize2 >= 0.0f) {
                                                            i3 = dimensionPixelSize;
                                                            z10 = true;
                                                        } else {
                                                            i3 = dimensionPixelSize;
                                                            z10 = false;
                                                        }
                                                        m535k(z10, "the border width cannot be < 0");
                                                        roundingParams.f3475e = dimensionPixelSize2;
                                                    } else {
                                                        i3 = dimensionPixelSize;
                                                        if (index == C10638R.a.GenericDraweeHierarchy_roundingBorderColor) {
                                                            if (genericDraweeHierarchyBuilder.f3468r == null) {
                                                                genericDraweeHierarchyBuilder.f3468r = new RoundingParams();
                                                            }
                                                            genericDraweeHierarchyBuilder.f3468r.f3476f = typedArrayObtainStyledAttributes.getColor(index, 0);
                                                        } else if (index == C10638R.a.GenericDraweeHierarchy_roundingBorderPadding) {
                                                            if (genericDraweeHierarchyBuilder.f3468r == null) {
                                                                genericDraweeHierarchyBuilder.f3468r = new RoundingParams();
                                                            }
                                                            RoundingParams roundingParams2 = genericDraweeHierarchyBuilder.f3468r;
                                                            float dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                            Objects.requireNonNull(roundingParams2);
                                                            m535k(dimensionPixelSize3 >= 0.0f, "the padding cannot be < 0");
                                                            roundingParams2.f3477g = dimensionPixelSize3;
                                                        }
                                                    }
                                                    dimensionPixelSize = i3;
                                                    z18 = z8;
                                                    i5++;
                                                    context2 = context;
                                                    z17 = z9;
                                                    i4 = 1;
                                                    indexCount = i2;
                                                }
                                            }
                                            i3 = dimensionPixelSize;
                                            dimensionPixelSize = i3;
                                            z18 = z8;
                                            i5++;
                                            context2 = context;
                                            z17 = z9;
                                            i4 = 1;
                                            indexCount = i2;
                                        }
                                    }
                                    i3 = dimensionPixelSize;
                                    z9 = z17;
                                    dimensionPixelSize = i3;
                                    z18 = z8;
                                    i5++;
                                    context2 = context;
                                    z17 = z9;
                                    i4 = 1;
                                    indexCount = i2;
                                }
                                z9 = z17;
                                i5++;
                                context2 = context;
                                z17 = z9;
                                i4 = 1;
                                indexCount = i2;
                            }
                        }
                        z9 = z17;
                        z8 = z18;
                        i3 = dimensionPixelSize;
                        dimensionPixelSize = i3;
                        z18 = z8;
                        i5++;
                        context2 = context;
                        z17 = z9;
                        i4 = 1;
                        indexCount = i2;
                    }
                    i2 = indexCount;
                    z9 = z17;
                    z8 = z18;
                    i3 = dimensionPixelSize;
                    dimensionPixelSize = i3;
                    z18 = z8;
                    i5++;
                    context2 = context;
                    z17 = z9;
                    i4 = 1;
                    indexCount = i2;
                }
                boolean z19 = z17;
                boolean z20 = z18;
                int i6 = dimensionPixelSize;
                typedArrayObtainStyledAttributes.recycle();
                if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                    z6 = z11 && z13;
                    z7 = z14 && z12;
                    z4 = z15 && z19;
                    z5 = z20 && z16;
                } else {
                    z6 = z11 && z12;
                    z7 = z14 && z13;
                    z4 = z15 && z16;
                    if (!z20 || !z19) {
                    }
                }
                i = i6;
                boolean z21 = z7;
                z3 = z6;
                z2 = z21;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                context.getResources().getConfiguration().getLayoutDirection();
                throw th;
            }
        } else {
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            i = 0;
            integer = 0;
        }
        if (genericDraweeHierarchyBuilder.f3462l != null && integer > 0) {
            genericDraweeHierarchyBuilder.f3462l = new AutoRotateDrawable(genericDraweeHierarchyBuilder.f3462l, integer);
        }
        if (i > 0) {
            if (genericDraweeHierarchyBuilder.f3468r == null) {
                genericDraweeHierarchyBuilder.f3468r = new RoundingParams();
            }
            RoundingParams roundingParams3 = genericDraweeHierarchyBuilder.f3468r;
            float f = z3 ? i : 0.0f;
            float f2 = z2 ? i : 0.0f;
            float f3 = z4 ? i : 0.0f;
            float f4 = z5 ? i : 0.0f;
            if (roundingParams3.f3473c == null) {
                roundingParams3.f3473c = new float[8];
            }
            float[] fArr = roundingParams3.f3473c;
            fArr[1] = f;
            fArr[0] = f;
            fArr[3] = f2;
            fArr[2] = f2;
            fArr[5] = f3;
            fArr[4] = f3;
            fArr[7] = f4;
            fArr[6] = f4;
        }
        return genericDraweeHierarchyBuilder;
    }

    @Pure
    /* renamed from: m */
    public static void m543m(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: m0 */
    public static void m544m0(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("cannot list directory " + file);
            }
            for (File file2 : fileArrListFiles) {
                m544m0(file2);
            }
            return;
        }
        if (file.getPath().endsWith("_lock")) {
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* renamed from: m1 */
    public static int m545m1(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & ViewCompat.MEASURED_SIZE_MASK;
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    /* renamed from: m2 */
    public static int m546m2(@RecentlyNonNull Parcel parcel) {
        int i = parcel.readInt();
        int iM455M1 = m455M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (((char) i) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw new SafeParcelReader$ParseException(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = iM455M1 + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new SafeParcelReader$ParseException(outline.m853h(54, "Size read is invalid start=", iDataPosition, " end=", i2), parcel);
        }
        return i2;
    }

    /* renamed from: n */
    public static void m547n(boolean z2, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* renamed from: n0 */
    public static int m548n0(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
    }

    /* renamed from: n1 */
    public static final Integer m549n1(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "$this$nextIntOrNull");
        if (jsonReader.mo6878N() != JsonToken.NULL) {
            return Integer.valueOf(jsonReader.mo6891y());
        }
        jsonReader.mo6876H();
        return null;
    }

    /* renamed from: n2 */
    public static boolean m550n2(int i, ParsableByteArray parsableByteArray, boolean z2) throws ParserException {
        if (parsableByteArray.m3081a() < 7) {
            if (z2) {
                return false;
            }
            throw outline.m884w0(29, "too short header: ", parsableByteArray.m3081a(), null);
        }
        if (parsableByteArray.m3100t() != i) {
            if (z2) {
                return false;
            }
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw ParserException.m8755a(strValueOf.length() != 0 ? "expected header type ".concat(strValueOf) : new String("expected header type "), null);
        }
        if (parsableByteArray.m3100t() == 118 && parsableByteArray.m3100t() == 111 && parsableByteArray.m3100t() == 114 && parsableByteArray.m3100t() == 98 && parsableByteArray.m3100t() == 105 && parsableByteArray.m3100t() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw ParserException.m8755a("expected characters 'vorbis'", null);
    }

    /* renamed from: o */
    public static void m551o(boolean z2, @RecentlyNonNull Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: o0 */
    public static int m552o0(int i) {
        return (int) (i * 1.3333334f);
    }

    @Nullable
    /* renamed from: o1 */
    public static <T> List<Keyframe<T>> m553o1(JsonReader2 jsonReader2, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.m632a(jsonReader2, lottieComposition, 1.0f, valueParser);
    }

    /* renamed from: o2 */
    public static void m554o2(File file, FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.mo943b(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    m554o2(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.mo942a(file2);
                }
            }
        }
        fileTreeVisitor.mo944c(file);
    }

    /* renamed from: p */
    public static void m555p(int i, int i2, int i3, int i4, int i5) {
        m527i(Boolean.valueOf(i4 >= 0));
        m527i(Boolean.valueOf(i >= 0));
        m527i(Boolean.valueOf(i3 >= 0));
        m527i(Boolean.valueOf(i + i4 <= i5));
        m527i(Boolean.valueOf(i3 + i4 <= i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: p0 */
    public static ScaleTypeDrawable m556p0(Drawable drawable) {
        if (drawable == 0) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return m556p0(((DrawableParent) drawable).mo1091l());
        }
        if (drawable instanceof ArrayDrawable2) {
            ArrayDrawable2 arrayDrawable2 = (ArrayDrawable2) drawable;
            int length = arrayDrawable2.f3328l.length;
            for (int i = 0; i < length; i++) {
                ScaleTypeDrawable scaleTypeDrawableM556p0 = m556p0(arrayDrawable2.m1093a(i));
                if (scaleTypeDrawableM556p0 != null) {
                    return scaleTypeDrawableM556p0;
                }
            }
        }
        return null;
    }

    /* renamed from: p1 */
    public static AnimatableColorValue m557p1(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(m553o1(jsonReader2, lottieComposition, ColorParser.f2228a));
    }

    /* renamed from: p2 */
    public static void m558p2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Bundle bundle, boolean z2) {
        if (bundle == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeBundle(bundle);
            m418A2(parcel, iM594y2);
        }
    }

    @Pure
    /* renamed from: q */
    public static void m559q(boolean z2, @Nullable String str) throws ParserException {
        if (!z2) {
            throw ParserException.m8755a(str, null);
        }
    }

    /* renamed from: q0 */
    public static Object m560q0(Object obj) {
        return new a(obj.getClass(), Array.getLength(obj), obj);
    }

    /* renamed from: q1 */
    public static AnimatableFloatValue m561q1(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        return m565r1(jsonReader2, lottieComposition, true);
    }

    /* renamed from: q2 */
    public static void m562q2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull byte[] bArr, boolean z2) {
        if (bArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeByteArray(bArr);
            m418A2(parcel, iM594y2);
        }
    }

    /* renamed from: r */
    public static boolean m563r(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        if (WavHeaderReader.m3800a(extractorInput, parsableByteArray).f8960a != 1380533830) {
            return false;
        }
        extractorInput.mo3652o(parsableByteArray.f6793a, 0, 4);
        parsableByteArray.m3079E(0);
        int iM3086f = parsableByteArray.m3086f();
        if (iM3086f == 1463899717) {
            return true;
        }
        StringBuilder sb = new StringBuilder(34);
        sb.append("Unsupported form type: ");
        sb.append(iM3086f);
        Log.e("WavHeaderReader", sb.toString());
        return false;
    }

    @Nullable
    /* renamed from: r0 */
    public static String m564r0(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    /* renamed from: r1 */
    public static AnimatableFloatValue m565r1(JsonReader2 jsonReader2, LottieComposition lottieComposition, boolean z2) throws IOException {
        return new AnimatableFloatValue(KeyframesParser.m632a(jsonReader2, lottieComposition, z2 ? Utils.m659c() : 1.0f, FloatParser.f2235a));
    }

    /* renamed from: r2 */
    public static void m566r2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull IBinder iBinder, boolean z2) {
        if (iBinder == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m418A2(parcel, iM594y2);
        }
    }

    /* renamed from: s */
    public static void m567s(@RecentlyNonNull Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name2).length() + 36 + String.valueOf(name).length());
            outline.m876s0(sb, "Must be called on ", name2, " thread, but got ", name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: s0 */
    public static int m568s0(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    /* renamed from: s1 */
    public static AnimatableIntegerValue m569s1(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(m553o1(jsonReader2, lottieComposition, IntegerParser.f2274a));
    }

    /* renamed from: s2 */
    public static void m570s2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable parcelable, int i2, boolean z2) {
        if (parcelable == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m418A2(parcel, iM594y2);
        }
    }

    @Pure
    /* renamed from: t */
    public static int m571t(int i, int i2, int i3) {
        if (i < i2 || i >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i;
    }

    /* renamed from: t0 */
    public static Object m572t0(JavaType javaType) {
        Class<?> cls = javaType._class;
        Class<?> clsM2190v = ClassUtil.m2190v(cls);
        if (clsM2190v == null) {
            if (javaType.mo2104v() || javaType.mo1728b()) {
                return JsonInclude.a.NON_EMPTY;
            }
            if (cls == String.class) {
                return "";
            }
            if (javaType.m2216B(Date.class)) {
                return new Date(0L);
            }
            if (!javaType.m2216B(Calendar.class)) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }
        if (clsM2190v == Integer.TYPE) {
            return 0;
        }
        if (clsM2190v == Long.TYPE) {
            return 0L;
        }
        if (clsM2190v == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clsM2190v == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (clsM2190v == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (clsM2190v == Byte.TYPE) {
            return (byte) 0;
        }
        if (clsM2190v == Short.TYPE) {
            return (short) 0;
        }
        if (clsM2190v == Character.TYPE) {
            return (char) 0;
        }
        throw new IllegalArgumentException(outline.m867o(clsM2190v, outline.m833U("Class "), " is not a primitive type"));
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01bc A[SYNTHETIC] */
    @Nullable
    /* renamed from: t1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<Projection.a> m573t1(ParsableByteArray parsableByteArray) {
        ArrayList<Projection.a> arrayList;
        int i;
        ArrayList<Projection.a> arrayList2;
        Projection.a aVar;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        if (parsableByteArray.m3100t() != 0) {
            return null;
        }
        parsableByteArray2.m3080F(7);
        int iM3086f = parsableByteArray.m3086f();
        if (iM3086f == 1684433976) {
            ParsableByteArray parsableByteArray3 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util2.m3016x(parsableByteArray2, parsableByteArray3, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray2 = parsableByteArray3;
            } finally {
                inflater.end();
            }
        } else if (iM3086f != 1918990112) {
            return null;
        }
        ArrayList<Projection.a> arrayList3 = new ArrayList<>();
        int i2 = parsableByteArray2.f6794b;
        int i3 = parsableByteArray2.f6795c;
        while (i2 < i3) {
            int iM3086f2 = parsableByteArray2.m3086f() + i2;
            if (iM3086f2 > i2 && iM3086f2 <= i3) {
                if (parsableByteArray2.m3086f() == 1835365224) {
                    int iM3086f3 = parsableByteArray2.m3086f();
                    if (iM3086f3 <= 10000) {
                        float[] fArr = new float[iM3086f3];
                        for (int i4 = 0; i4 < iM3086f3; i4++) {
                            fArr[i4] = Float.intBitsToFloat(parsableByteArray2.m3086f());
                        }
                        int iM3086f4 = parsableByteArray2.m3086f();
                        if (iM3086f4 <= 32000) {
                            double dLog = Math.log(2.0d);
                            arrayList2 = arrayList3;
                            int iCeil = (int) Math.ceil(Math.log(iM3086f3 * 2.0d) / dLog);
                            ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray2.f6793a);
                            parsableBitArray.m3071k(parsableByteArray2.f6794b * 8);
                            float[] fArr2 = new float[iM3086f4 * 5];
                            int i5 = 5;
                            int[] iArr = new int[5];
                            int i6 = 0;
                            int i7 = 0;
                            while (true) {
                                if (i6 < iM3086f4) {
                                    int i8 = 0;
                                    while (i8 < i5) {
                                        int i9 = iArr[i8];
                                        int iM3067g = parsableBitArray.m3067g(iCeil);
                                        int i10 = i9 + ((-(iM3067g & 1)) ^ (iM3067g >> 1));
                                        if (i10 >= iM3086f3 || i10 < 0) {
                                            break;
                                        }
                                        fArr2[i7] = fArr[i10];
                                        iArr[i8] = i10;
                                        i8++;
                                        i7++;
                                        i5 = 5;
                                    }
                                    i6++;
                                    i5 = 5;
                                } else {
                                    parsableBitArray.m3071k((parsableBitArray.m3065e() + 7) & (-8));
                                    int i11 = 32;
                                    int iM3067g2 = parsableBitArray.m3067g(32);
                                    Projection.b[] bVarArr = new Projection.b[iM3067g2];
                                    int i12 = 0;
                                    while (i12 < iM3067g2) {
                                        int iM3067g3 = parsableBitArray.m3067g(8);
                                        int iM3067g4 = parsableBitArray.m3067g(8);
                                        int iM3067g5 = parsableBitArray.m3067g(i11);
                                        if (iM3067g5 <= 128000) {
                                            i = i3;
                                            int iCeil2 = (int) Math.ceil(Math.log(iM3086f4 * 2.0d) / dLog);
                                            float[] fArr3 = new float[iM3067g5 * 3];
                                            float[] fArr4 = new float[iM3067g5 * 2];
                                            int i13 = 0;
                                            int i14 = 0;
                                            while (i13 < iM3067g5) {
                                                int iM3067g6 = parsableBitArray.m3067g(iCeil2);
                                                int i15 = iM3067g6 >> 1;
                                                ParsableBitArray parsableBitArray2 = parsableBitArray;
                                                int i16 = iM3067g6 & 1;
                                                int i17 = iM3067g2;
                                                float[] fArr5 = fArr4;
                                                int i18 = i14 + ((-i16) ^ i15);
                                                if (i18 >= 0 && i18 < iM3086f4) {
                                                    int i19 = i13 * 3;
                                                    int i20 = i18 * 5;
                                                    fArr3[i19] = fArr2[i20];
                                                    fArr3[i19 + 1] = fArr2[i20 + 1];
                                                    fArr3[i19 + 2] = fArr2[i20 + 2];
                                                    int i21 = i13 * 2;
                                                    fArr5[i21] = fArr2[i20 + 3];
                                                    fArr5[i21 + 1] = fArr2[i20 + 4];
                                                    i13++;
                                                    i14 = i18;
                                                    fArr4 = fArr5;
                                                    iM3067g2 = i17;
                                                    parsableBitArray = parsableBitArray2;
                                                }
                                            }
                                            bVarArr[i12] = new Projection.b(iM3067g3, fArr3, fArr4, iM3067g4);
                                            i12++;
                                            i3 = i;
                                            iM3067g2 = iM3067g2;
                                            i11 = 32;
                                        }
                                    }
                                    i = i3;
                                    aVar = new Projection.a(bVarArr);
                                }
                            }
                        }
                        i = i3;
                        aVar = null;
                        if (aVar == null) {
                            arrayList = arrayList2;
                            arrayList.add(aVar);
                        }
                    }
                    arrayList2 = arrayList3;
                    i = i3;
                    aVar = null;
                    if (aVar == null) {
                    }
                } else {
                    arrayList = arrayList3;
                    i = i3;
                }
                parsableByteArray2.m3079E(iM3086f2);
                arrayList3 = arrayList;
                i2 = iM3086f2;
                i3 = i;
            }
            return null;
        }
        return arrayList3;
    }

    /* renamed from: t2 */
    public static void m574t2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String str, boolean z2) {
        if (str == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeString(str);
            m418A2(parcel, iM594y2);
        }
    }

    /* renamed from: u */
    public static void m575u(@RecentlyNonNull String str) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: u0 */
    public static Drawable m576u0(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    /* renamed from: u1 */
    public static AnimatablePointValue m577u1(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(KeyframesParser.m632a(jsonReader2, lottieComposition, Utils.m659c(), PointFParser.f2289a));
    }

    /* renamed from: u2 */
    public static void m578u2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String[] strArr, boolean z2) {
        if (strArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iM594y2 = m594y2(parcel, i);
            parcel.writeStringArray(strArr);
            m418A2(parcel, iM594y2);
        }
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    /* renamed from: v */
    public static String m579v(@Nullable String str, @RecentlyNonNull Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @RecentlyNonNull
    /* renamed from: v0 */
    public static String m580v0(@RecentlyNonNull PowerManager.WakeLock wakeLock, @RecentlyNonNull String str) {
        String strValueOf = String.valueOf(String.valueOf(System.identityHashCode(wakeLock) | (Process.myPid() << 32)));
        String strValueOf2 = String.valueOf(true == TextUtils.isEmpty(null) ? "" : null);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    @Nullable
    /* renamed from: v1 */
    public static PsshAtomUtil m581v1(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.f6795c < 32) {
            return null;
        }
        parsableByteArray.m3079E(0);
        if (parsableByteArray.m3086f() != parsableByteArray.m3081a() + 4 || parsableByteArray.m3086f() != 1886614376) {
            return null;
        }
        int iM3086f = (parsableByteArray.m3086f() >> 24) & 255;
        if (iM3086f > 1) {
            outline.m852g0(37, "Unsupported pssh version: ", iM3086f, "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.m3093m(), parsableByteArray.m3093m());
        if (iM3086f == 1) {
            parsableByteArray.m3080F(parsableByteArray.m3103w() * 16);
        }
        int iM3103w = parsableByteArray.m3103w();
        if (iM3103w != parsableByteArray.m3081a()) {
            return null;
        }
        byte[] bArr2 = new byte[iM3103w];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr2, 0, iM3103w);
        parsableByteArray.f6794b += iM3103w;
        return new PsshAtomUtil(uuid, iM3086f, bArr2);
    }

    /* renamed from: v2 */
    public static <T extends Parcelable> void m582v2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull T[] tArr, int i2, boolean z2) {
        if (tArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
                return;
            }
            return;
        }
        int iM594y2 = m594y2(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m422B2(parcel, t, i2);
            }
        }
        m418A2(parcel, iM594y2);
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    /* renamed from: w */
    public static String m583w(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    /* renamed from: w0 */
    public static int m584w0(InputStream inputStream) throws IOException {
        byte b2 = (byte) inputStream.read();
        byte b3 = (byte) inputStream.read();
        return ((((byte) inputStream.read()) << 24) & ViewCompat.MEASURED_STATE_MASK) | ((((byte) inputStream.read()) << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((b3 << 8) & 65280) | (b2 & 255);
    }

    @Nullable
    /* renamed from: w1 */
    public static byte[] m585w1(byte[] bArr, UUID uuid) {
        PsshAtomUtil psshAtomUtilM581v1 = m581v1(bArr);
        if (psshAtomUtilM581v1 == null) {
            return null;
        }
        if (uuid.equals(psshAtomUtilM581v1.f8449a)) {
            return psshAtomUtilM581v1.f8451c;
        }
        String strValueOf = String.valueOf(uuid);
        String strValueOf2 = String.valueOf(psshAtomUtilM581v1.f8449a);
        outline.m874r0(outline.m831S(strValueOf2.length() + strValueOf.length() + 33, "UUID mismatch. Expected: ", strValueOf, ", got: ", strValueOf2), ".", "PsshAtomUtil");
        return null;
    }

    /* renamed from: w2 */
    public static <T extends Parcelable> void m586w2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<T> list, boolean z2) {
        if (list == null) {
            if (z2) {
                parcel.writeInt(i | 0);
                return;
            }
            return;
        }
        int iM594y2 = m594y2(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m422B2(parcel, t, 0);
            }
        }
        m418A2(parcel, iM594y2);
    }

    /* renamed from: x */
    public static void m587x(@RecentlyNonNull String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: x0 */
    public static final Integer m588x0(Intent intent, String str) {
        Intrinsics3.checkNotNullParameter(intent, "$this$getIntExtraOrNull");
        Intrinsics3.checkNotNullParameter(str, "key");
        Integer numValueOf = Integer.valueOf(intent.getIntExtra(str, Integer.MIN_VALUE));
        if (numValueOf.intValue() == Integer.MIN_VALUE) {
            return null;
        }
        return numValueOf;
    }

    /* renamed from: x1 */
    public static boolean m589x1(ExtractorInput extractorInput, byte[] bArr, int i, int i2, boolean z2) throws IOException {
        try {
            return extractorInput.mo3644e(bArr, i, i2, z2);
        } catch (EOFException e) {
            if (z2) {
                return false;
            }
            throw e;
        }
    }

    /* renamed from: x2 */
    public static void m590x2(Parcel parcel, int i, int i2) {
        int iM455M1 = m455M1(parcel, i);
        if (iM455M1 == i2) {
            return;
        }
        String hexString = Integer.toHexString(iM455M1);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(iM455M1);
        throw new SafeParcelReader$ParseException(outline.m823K(sb, " (0x", hexString, ")"), parcel);
    }

    /* renamed from: y */
    public static <T> T m591y(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: y0 */
    public static final StageRequestToSpeakState m592y0(VoiceState voiceState) {
        return voiceState == null ? StageRequestToSpeakState.NONE : (!voiceState.getSuppress() || voiceState.getRequestToSpeakTimestamp() == null) ? (voiceState.getSuppress() || voiceState.getRequestToSpeakTimestamp() == null) ? !voiceState.getSuppress() ? StageRequestToSpeakState.ON_STAGE : StageRequestToSpeakState.NONE : StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK : StageRequestToSpeakState.REQUESTED_TO_SPEAK;
    }

    @Nullable
    /* renamed from: y1 */
    public static Metadata m593y1(ExtractorInput extractorInput, boolean z2) throws IOException {
        C3166a c3166a;
        if (z2) {
            c3166a = null;
        } else {
            int i = Id3Decoder.f9154a;
            c3166a = C3166a.f9153a;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        Metadata metadataM3922d = null;
        int i2 = 0;
        while (true) {
            try {
                extractorInput.mo3652o(parsableByteArray.f6793a, 0, 10);
                parsableByteArray.m3079E(0);
                if (parsableByteArray.m3102v() != 4801587) {
                    break;
                }
                parsableByteArray.m3080F(3);
                int iM3099s = parsableByteArray.m3099s();
                int i3 = iM3099s + 10;
                if (metadataM3922d == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(parsableByteArray.f6793a, 0, bArr, 0, 10);
                    extractorInput.mo3652o(bArr, 10, iM3099s);
                    metadataM3922d = new Id3Decoder(c3166a).m3922d(bArr, i3);
                } else {
                    extractorInput.mo3646g(iM3099s);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        extractorInput.mo3649k();
        extractorInput.mo3646g(i2);
        if (metadataM3922d == null || metadataM3922d.f19936j.length == 0) {
            return null;
        }
        return metadataM3922d;
    }

    /* renamed from: y2 */
    public static int m594y2(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    /* renamed from: z */
    public static <T> T m595z(@RecentlyNonNull T t, @RecentlyNonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: z0 */
    public static List<String> m596z0(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                Objects.requireNonNull((MultiCacheKey) cacheKey);
                throw null;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(cacheKey.mo929a() ? cacheKey.mo930b() : m485W1(cacheKey));
            return arrayList;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: z1 */
    public static int m597z1(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int iMo3648i = extractorInput.mo3648i(bArr, i + i3, i2 - i3);
            if (iMo3648i == -1) {
                break;
            }
            i3 += iMo3648i;
        }
        return i3;
    }

    /* renamed from: z2 */
    public static void m598z2(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        throw new SafeParcelReader$ParseException(outline.m823K(sb, " (0x", hexString, ")"), parcel);
    }
}
