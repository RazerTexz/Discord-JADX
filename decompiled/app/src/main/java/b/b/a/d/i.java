package b.b.a.d;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.f.g.e.r;
import b.f.g.e.s;
import com.discord.utilities.color.ColorCompat;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.model.Media;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import s.a.a.n;
import s.a.k0;
import s.a.x0;

/* compiled from: ThumbnailViewHolder.kt */
/* loaded from: classes3.dex */
public abstract class i extends RecyclerView.ViewHolder {
    public static int j;
    public static int k;
    public static ColorDrawable l;
    public static final a m = new a(null);
    public b n;
    public c o;

    /* compiled from: ThumbnailViewHolder.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final boolean a(a aVar) {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* compiled from: ThumbnailViewHolder.kt */
    @RequiresApi(29)
    public static final class b {
        public Job a;

        /* renamed from: b, reason: collision with root package name */
        public CancellationSignal f321b;
        public Bitmap c;
        public final ContentResolver d;

        public b(ContentResolver contentResolver) {
            d0.z.d.m.checkNotNullParameter(contentResolver, "contentResolver");
            this.d = contentResolver;
        }

        public final void a() {
            if (a.a(i.m)) {
                Job job = this.a;
                if (job != null) {
                    b.i.a.f.e.o.f.t(job, null, 1, null);
                }
                CancellationSignal cancellationSignal = this.f321b;
                if (cancellationSignal != null) {
                    cancellationSignal.cancel();
                }
            }
            Bitmap bitmap = this.c;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.c = null;
        }
    }

    /* compiled from: ThumbnailViewHolder.kt */
    public static final class c {
        public final ContentResolver a;

        public c(ContentResolver contentResolver) {
            d0.z.d.m.checkNotNullParameter(contentResolver, "contentResolver");
            this.a = contentResolver;
        }
    }

    /* compiled from: ThumbnailViewHolder.kt */
    public static final class d extends o implements Function1<Bitmap, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bitmap bitmap) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(i.this.a().getResources(), bitmap);
            GenericDraweeHierarchy hierarchy = i.this.a().getHierarchy();
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = s.l;
            hierarchy.o(1, bitmapDrawable);
            hierarchy.l(1).r(scalingUtils$ScaleType2);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(View view) {
        super(view);
        d0.z.d.m.checkNotNullParameter(view, "itemView");
        if (Build.VERSION.SDK_INT >= 29) {
            Context context = view.getContext();
            d0.z.d.m.checkNotNullExpressionValue(context, "itemView.context");
            ContentResolver contentResolver = context.getContentResolver();
            d0.z.d.m.checkNotNullExpressionValue(contentResolver, "itemView.context.contentResolver");
            this.n = new b(contentResolver);
            return;
        }
        Context context2 = view.getContext();
        d0.z.d.m.checkNotNullExpressionValue(context2, "itemView.context");
        ContentResolver contentResolver2 = context2.getContentResolver();
        d0.z.d.m.checkNotNullExpressionValue(contentResolver2, "itemView.context.contentResolver");
        this.o = new c(contentResolver2);
    }

    public abstract SimpleDraweeView a();

    public final void b() {
        b bVar;
        if (!(Build.VERSION.SDK_INT >= 29) || (bVar = this.n) == null) {
            return;
        }
        bVar.a();
    }

    public final void c(Media media, Integer num, Integer num2) {
        if (l == null) {
            View view = this.itemView;
            d0.z.d.m.checkNotNullExpressionValue(view, "itemView");
            l = new ColorDrawable(ColorCompat.getThemedColor(view, R.b.flexInputDialogBackground));
        }
        if (num != null) {
            j = num.intValue();
        }
        if (num2 != null) {
            k = num2.intValue();
        }
        if (media == null) {
            return;
        }
        Uri uri = null;
        if (Build.VERSION.SDK_INT >= 29) {
            GenericDraweeHierarchy hierarchy = a().getHierarchy();
            ColorDrawable colorDrawable = l;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            hierarchy.q(colorDrawable, r.l);
            b bVar = this.n;
            if (bVar != null) {
                Uri uri2 = media.getUri();
                d dVar = new d();
                d0.z.d.m.checkNotNullParameter(uri2, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                d0.z.d.m.checkNotNullParameter(dVar, "onGenerate");
                bVar.a();
                x0 x0Var = x0.j;
                CoroutineDispatcher coroutineDispatcher = k0.a;
                bVar.a = b.i.a.f.e.o.f.H0(x0Var, n.f3830b, null, new j(bVar, uri2, dVar, null), 2, null);
                return;
            }
            return;
        }
        c cVar = this.o;
        if (cVar != null) {
            long id2 = media.getId();
            Uri uri3 = media.getUri();
            d0.z.d.m.checkNotNullParameter(uri3, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            m mVar = new m(id2);
            Cursor cursorQuery = cVar.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "image_id = ? AND KIND = ?", new String[]{String.valueOf(id2), String.valueOf(1)}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                ContentResolver contentResolver = cVar.a;
                d0.z.d.m.checkNotNullParameter(contentResolver, "contentResolver");
                AsyncTask.execute(new l(mVar, contentResolver));
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } else {
                try {
                    uri3 = ContentUris.withAppendedId(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, cursorQuery.getLong(0));
                    d0.y.b.closeFinally(cursorQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        d0.y.b.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            }
            uri = uri3;
        }
        a().setImageURI(uri, a().getContext());
    }
}
