package p492b0.p493a.p494a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p492b0.p493a.p494a.p495e.Compression;
import p492b0.p493a.p494a.p495e.Constraint2;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p591y.Closeable;
import p507d0.p591y.IOStreams;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Compressor.kt */
@DebugMetadata(m10084c = "id.zelory.compressor.Compressor$compress$6", m10085f = "Compressor.kt", m10086l = {}, m10087m = "invokeSuspend")
/* renamed from: b0.a.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Compressor2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    public final /* synthetic */ Function1 $compressionPatch;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Uri $imageFileUri;
    public int label;

    /* renamed from: p$ */
    private CoroutineScope f14502p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Compressor2(Function1 function1, Context context, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.$compressionPatch = function1;
        this.$context = context;
        this.$imageFileUri = uri;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkParameterIsNotNull(continuation, "completion");
        Compressor2 compressor2 = new Compressor2(this.$compressionPatch, this.$context, this.$imageFileUri, continuation);
        compressor2.f14502p$ = (CoroutineScope) obj;
        return compressor2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        Continuation<? super File> continuation2 = continuation;
        Intrinsics3.checkParameterIsNotNull(continuation2, "completion");
        Compressor2 compressor2 = new Compressor2(this.$compressionPatch, this.$context, this.$imageFileUri, continuation2);
        compressor2.f14502p$ = coroutineScope;
        return compressor2.invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        String string;
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        Compression compression = new Compression();
        this.$compressionPatch.invoke(compression);
        Context context = this.$context;
        Uri uri = this.$imageFileUri;
        String str = Util3.f14504a;
        Intrinsics3.checkParameterIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(uri, "srcFileUri");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        File cacheDir = context.getCacheDir();
        Intrinsics3.checkExpressionValueIsNotNull(cacheDir, "context.cacheDir");
        sb2.append(cacheDir.getPath());
        String str2 = Util3.f14504a;
        sb2.append(str2);
        sb2.append("compressor");
        sb2.append(str2);
        sb.append(sb2.toString());
        Intrinsics3.checkParameterIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery == null) {
            try {
                Intrinsics3.throwNpe();
            } finally {
            }
        }
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        if (cursorQuery.moveToFirst()) {
            string = cursorQuery.getString(columnIndex);
            Intrinsics3.checkExpressionValueIsNotNull(string, "it.getString(nameIndex)");
            Closeable.closeFinally(cursorQuery, null);
        } else {
            String str3 = "IMG_" + new SimpleDateFormat("yyyyMMdd_", Locale.getDefault()).format(new Date()) + System.nanoTime();
            String type = contentResolver.getType(uri);
            if (Intrinsics3.areEqual(type, "image/jpg") || Intrinsics3.areEqual(type, "image/jpeg")) {
                string = str3 + ".jpeg";
            } else {
                if (!Intrinsics3.areEqual(type, "image/png")) {
                    throw new IllegalStateException(type + " fallback display name not supported");
                }
                string = str3 + ".png";
            }
            Closeable.closeFinally(cursorQuery, null);
        }
        sb.append(string);
        File file = new File(sb.toString());
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        file.deleteOnExit();
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(context.getContentResolver().openFileDescriptor(uri, "r"));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            try {
                IOStreams.copyTo$default(autoCloseInputStream, fileOutputStream, 0, 2, null);
                Closeable.closeFinally(fileOutputStream, null);
                Closeable.closeFinally(autoCloseInputStream, null);
                for (Constraint2 constraint2 : compression.f14505a) {
                    while (!constraint2.mo7490b(file)) {
                        file = constraint2.mo7489a(file);
                    }
                }
                return file;
            } finally {
            }
        } finally {
        }
    }
}
