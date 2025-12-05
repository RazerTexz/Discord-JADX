package p007b.p076b.p077a.p079d;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.time.TimeUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import p007b.p076b.p077a.p080e.ViewGridImageBinding;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: MediaCursorAdapter.kt */
/* renamed from: b.b.a.d.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class MediaCursorAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a */
    public final SelectionCoordinator<?, Media> f2144a;

    /* renamed from: b */
    public Cursor f2145b;

    /* renamed from: c */
    public int f2146c;

    /* renamed from: d */
    public int f2147d;

    /* renamed from: e */
    public int f2148e;

    /* renamed from: f */
    public int f2149f;

    /* renamed from: g */
    public Integer f2150g;

    /* renamed from: h */
    public final int f2151h;

    /* renamed from: i */
    public final int f2152i;

    /* compiled from: MediaCursorAdapter.kt */
    /* renamed from: b.b.a.d.h$a */
    public final class a extends ThumbnailViewHolder implements View.OnClickListener {

        /* renamed from: p */
        public Media f2153p;

        /* renamed from: q */
        public final AnimatorSet f2154q;

        /* renamed from: r */
        public final AnimatorSet f2155r;

        /* renamed from: s */
        public final ViewGridImageBinding f2156s;

        /* renamed from: t */
        public final /* synthetic */ MediaCursorAdapter f2157t;

        /* compiled from: MediaCursorAdapter.kt */
        /* renamed from: b.b.a.d.h$a$a, reason: collision with other inner class name */
        public static final class C13219a extends Lambda implements Function1<AnimatorSet, Unit> {
            public final /* synthetic */ boolean $isAnimationRequested;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13219a(boolean z2) {
                super(1);
                this.$isAnimationRequested = z2;
            }

            /* renamed from: a */
            public final void m403a(AnimatorSet animatorSet) {
                Intrinsics3.checkNotNullParameter(animatorSet, "animation");
                animatorSet.start();
                if (this.$isAnimationRequested) {
                    return;
                }
                animatorSet.end();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimatorSet animatorSet) {
                m403a(animatorSet);
                return Unit.f27425a;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(MediaCursorAdapter mediaCursorAdapter, ViewGridImageBinding viewGridImageBinding) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(viewGridImageBinding, "binding");
            this.f2157t = mediaCursorAdapter;
            FrameLayout frameLayout = viewGridImageBinding.f2194a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout);
            this.f2156s = viewGridImageBinding;
            viewGridImageBinding.f2194a.setOnClickListener(this);
            FrameLayout frameLayout2 = viewGridImageBinding.f2194a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.root");
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(frameLayout2.getContext(), C11170R.a.selection_shrink);
            Objects.requireNonNull(animatorLoadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
            this.f2154q = animatorSet;
            animatorSet.setTarget(viewGridImageBinding.f2195b);
            FrameLayout frameLayout3 = viewGridImageBinding.f2194a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.root");
            Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(frameLayout3.getContext(), C11170R.a.selection_grow);
            Objects.requireNonNull(animatorLoadAnimator2, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
            this.f2155r = animatorSet2;
            animatorSet2.setTarget(viewGridImageBinding.f2195b);
        }

        @Override // p007b.p076b.p077a.p079d.ThumbnailViewHolder
        /* renamed from: a */
        public SimpleDraweeView mo401a() {
            SimpleDraweeView simpleDraweeView = this.f2156s.f2196c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.contentIv");
            return simpleDraweeView;
        }

        /* renamed from: d */
        public final void m402d(boolean z2, boolean z3) {
            FrameLayout frameLayout = this.f2156s.f2194a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            frameLayout.setSelected(z2);
            C13219a c13219a = new C13219a(z3);
            if (z2) {
                SimpleDraweeView simpleDraweeView = this.f2156s.f2197d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemCheckIndicator");
                simpleDraweeView.setVisibility(0);
                FrameLayout frameLayout2 = this.f2156s.f2195b;
                Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.contentContainer");
                if (frameLayout2.getScaleX() == 1.0f) {
                    c13219a.m403a(this.f2154q);
                    return;
                }
                return;
            }
            SimpleDraweeView simpleDraweeView2 = this.f2156s.f2197d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemCheckIndicator");
            simpleDraweeView2.setVisibility(8);
            FrameLayout frameLayout3 = this.f2156s.f2195b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.contentContainer");
            if (frameLayout3.getScaleX() != 1.0f) {
                c13219a.m403a(this.f2155r);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics3.checkNotNullParameter(view, "v");
            SelectionCoordinator<?, Media> selectionCoordinator = this.f2157t.f2144a;
            Media media = this.f2153p;
            int adapterPosition = getAdapterPosition();
            Objects.requireNonNull(selectionCoordinator);
            if (media == null || selectionCoordinator.m9301d(media)) {
                return;
            }
            selectionCoordinator.m9300c(media, adapterPosition);
        }
    }

    /* compiled from: MediaCursorAdapter.kt */
    /* renamed from: b.b.a.d.h$b */
    public static final class b extends AsyncQueryHandler {
        public b(ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            Intrinsics3.checkNotNullParameter(obj, "cookie");
            if (cursor == null) {
                return;
            }
            MediaCursorAdapter mediaCursorAdapter = MediaCursorAdapter.this;
            mediaCursorAdapter.f2146c = cursor.getColumnIndex("_id");
            mediaCursorAdapter.f2147d = cursor.getColumnIndex("_data");
            mediaCursorAdapter.f2148e = cursor.getColumnIndex("_display_name");
            mediaCursorAdapter.f2149f = cursor.getColumnIndex("media_type");
            if (Build.VERSION.SDK_INT >= 29) {
                mediaCursorAdapter.f2150g = Integer.valueOf(cursor.getColumnIndex("duration"));
            }
            mediaCursorAdapter.f2145b = cursor;
            MediaCursorAdapter.this.notifyDataSetChanged();
        }
    }

    public MediaCursorAdapter(SelectionCoordinator<?, Media> selectionCoordinator, int i, int i2) {
        Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        this.f2151h = i;
        this.f2152i = i2;
        Objects.requireNonNull(selectionCoordinator);
        Intrinsics3.checkNotNullParameter(this, "adapter");
        selectionCoordinator.adapter = this;
        this.f2144a = selectionCoordinator;
        setHasStableIds(true);
    }

    /* renamed from: a */
    public final Media m399a(int i) {
        String str;
        Cursor cursor = this.f2145b;
        Media media = null;
        lValueOf = null;
        Long lValueOf = null;
        if (cursor != null) {
            cursor.moveToPosition(i);
            long j = cursor.getLong(this.f2146c);
            boolean z2 = cursor.getInt(this.f2149f) == 3;
            Uri uriWithAppendedPath = z2 ? Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, String.valueOf(j)) : Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(j));
            String str2 = z2 ? "vid" : "img";
            Integer num = this.f2150g;
            if (z2 && num != null) {
                lValueOf = Long.valueOf(cursor.getLong(num.intValue()));
            }
            Long l = lValueOf;
            Intrinsics3.checkNotNullExpressionValue(uriWithAppendedPath, "fileUri");
            String string = cursor.getString(this.f2148e);
            if (string != null) {
                str = string;
            } else {
                str = str2 + '-' + j;
            }
            media = new Media(j, uriWithAppendedPath, str, cursor.getString(this.f2147d), z2, l);
        }
        return media;
    }

    /* renamed from: b */
    public final void m400b(ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        int i = Build.VERSION.SDK_INT;
        String str = i >= 29 ? "media_type = 1 OR media_type = 3" : "media_type = 1";
        new b(contentResolver).startQuery(1, this, MediaStore.Files.getContentUri("external"), i >= 29 ? new String[]{"_id", "_data", "_display_name", "media_type", "duration"} : new String[]{"_id", "_data", "_display_name", "media_type"}, str, null, "date_added DESC");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        Cursor cursor = this.f2145b;
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Media mediaM399a = m399a(i);
        if (mediaM399a != null) {
            return mediaM399a.getId();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recyclerView.context");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "recyclerView.context.contentResolver");
        m400b(contentResolver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Long l;
        a aVar = (a) viewHolder;
        Intrinsics3.checkNotNullParameter(aVar, "holder");
        Media mediaM399a = m399a(i);
        aVar.f2153p = mediaM399a;
        FrameLayout frameLayout = aVar.f2156s.f2194a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
        Context context = frameLayout.getContext();
        if (mediaM399a != null) {
            aVar.m402d(aVar.f2157t.f2144a.m9298a(mediaM399a, aVar.getAdapterPosition()), false);
        }
        aVar.m405c(mediaM399a, Integer.valueOf(aVar.f2157t.f2151h), Integer.valueOf(aVar.f2157t.f2152i));
        boolean z2 = mediaM399a != null && mediaM399a.f22082j;
        TextView textView = aVar.f2156s.f2198e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemVideoIndicator");
        textView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            TextView textView2 = aVar.f2156s.f2198e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemVideoIndicator");
            Drawable background = textView2.getBackground();
            Intrinsics3.checkNotNullExpressionValue(background, "binding.itemVideoIndicator.background");
            background.setAlpha(Opcodes.LAND);
            long jLongValue = (mediaM399a == null || (l = mediaM399a.f22083k) == null) ? 0L : l.longValue();
            TextView textView3 = aVar.f2156s.f2198e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemVideoIndicator");
            textView3.setText(jLongValue > 0 ? TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, jLongValue, null, null, 6, null) : context.getString(C11170R.h.video));
        }
        SimpleDraweeView simpleDraweeView = aVar.f2156s.f2196c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.contentIv");
        simpleDraweeView.setContentDescription(context.getString(z2 ? C11170R.h.video : C11170R.h.image));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C11170R.g.view_grid_image, viewGroup, false);
        int i2 = C11170R.f.content_container;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(i2);
        if (frameLayout != null) {
            i2 = C11170R.f.content_iv;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView != null) {
                i2 = C11170R.f.item_check_indicator;
                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView2 != null) {
                    i2 = C11170R.f.item_video_indicator;
                    TextView textView = (TextView) viewInflate.findViewById(i2);
                    if (textView != null) {
                        ViewGridImageBinding viewGridImageBinding = new ViewGridImageBinding((FrameLayout) viewInflate, frameLayout, simpleDraweeView, simpleDraweeView2, textView);
                        Intrinsics3.checkNotNullExpressionValue(viewGridImageBinding, "ViewGridImageBinding.inf….context), parent, false)");
                        return new a(this, viewGridImageBinding);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Cursor cursor = this.f2145b;
        if (cursor != null) {
            cursor.close();
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        a aVar = (a) viewHolder;
        Intrinsics3.checkNotNullParameter(aVar, "holder");
        super.onViewRecycled(aVar);
        aVar.m404b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        Object next;
        a aVar = (a) viewHolder;
        Intrinsics3.checkNotNullParameter(aVar, "holder");
        Intrinsics3.checkNotNullParameter(list, "payloads");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next instanceof SelectionCoordinator.C11192a) {
                    break;
                }
            }
        }
        if (next != null) {
            SelectionCoordinator.C11192a c11192a = (SelectionCoordinator.C11192a) (next instanceof SelectionCoordinator.C11192a ? next : null);
            if (c11192a != null) {
                aVar.m402d(c11192a.f22090b, true);
                return;
            }
        }
        super.onBindViewHolder(aVar, i, list);
    }
}
