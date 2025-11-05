package com.lytefast.flexinput.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.d.i;
import b.f.g.a.a.d;
import b.f.j.d.e;
import b.f.j.d.f;
import com.discord.utilities.drawable.DrawableCompat;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: AttachmentPreviewAdapter.kt */
/* loaded from: classes3.dex */
public final class AttachmentPreviewAdapter<T extends Attachment<? extends Object>> extends RecyclerView.Adapter<AttachmentPreviewAdapter<T>.b> {

    /* renamed from: a, reason: from kotlin metadata */
    public final SelectionAggregator<T> selectionAggregator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean useBottomSheet;

    /* renamed from: c, reason: from kotlin metadata */
    public final Function2<SelectionAggregator<T>, T, Unit> onAttachmentSelected;

    /* compiled from: AttachmentPreviewAdapter.kt */
    public static final class a extends o implements Function2<SelectionAggregator<T>, T, Unit> {
        public static final a j = new a();

        public a() {
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Object obj, Object obj2) {
            SelectionAggregator selectionAggregator = (SelectionAggregator) obj;
            Attachment attachment = (Attachment) obj2;
            m.checkNotNullParameter(selectionAggregator, "aggregator");
            m.checkNotNullParameter(attachment, "attachment");
            selectionAggregator.unselectItem(attachment);
            return Unit.a;
        }
    }

    /* compiled from: AttachmentPreviewAdapter.kt */
    public final class b extends i {
        public final b.b.a.e.b p;
        public final Function2<SelectionAggregator<T>, T, Unit> q;
        public final /* synthetic */ AttachmentPreviewAdapter r;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public b(AttachmentPreviewAdapter attachmentPreviewAdapter, b.b.a.e.b bVar, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2) {
            m.checkNotNullParameter(bVar, "binding");
            m.checkNotNullParameter(function2, "onAttachmentSelected");
            this.r = attachmentPreviewAdapter;
            ConstraintLayout constraintLayout = bVar.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout);
            this.p = bVar;
            this.q = function2;
            GenericDraweeHierarchy hierarchy = a().getHierarchy();
            Context context = a().getContext();
            m.checkNotNullExpressionValue(context, "imageView.context");
            hierarchy.p(DrawableCompat.getThemedDrawableRes$default(context, R.b.ic_flex_input_file, 0, 2, (Object) null));
        }

        @Override // b.b.a.d.i
        public SimpleDraweeView a() {
            SimpleDraweeView simpleDraweeView = this.p.f323b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentItem");
            return simpleDraweeView;
        }
    }

    public AttachmentPreviewAdapter() {
        this(false, null, null, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AttachmentPreviewAdapter(boolean z2, Function2 function2, Function1 function1, int i) {
        z2 = (i & 1) != 0 ? false : z2;
        a aVar = (i & 2) != 0 ? a.j : null;
        int i2 = i & 4;
        this(z2, aVar, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.selectionAggregator.getSize();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        b bVar = (b) viewHolder;
        m.checkNotNullParameter(bVar, "holder");
        Attachment attachment = this.selectionAggregator.get(i);
        Objects.requireNonNull(bVar);
        m.checkNotNullParameter(attachment, "item");
        if (attachment instanceof Media) {
            bVar.a().setController(null);
            bVar.c((Media) attachment, null, null);
        } else {
            int dimensionPixelSize = bVar.a().getResources().getDimensionPixelSize(R.d.attachment_preview_dimen);
            ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(attachment.getUri());
            imageRequestBuilderB.e = f.a;
            imageRequestBuilderB.d = new e(dimensionPixelSize, dimensionPixelSize);
            d dVarA = b.f.g.a.a.b.a();
            dVarA.n = bVar.a().getController();
            dVarA.m = true;
            dVarA.h = imageRequestBuilderB.a();
            bVar.a().setController(dVarA.a());
        }
        if (!bVar.r.useBottomSheet) {
            SimpleDraweeView simpleDraweeView = bVar.p.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentRemove");
            simpleDraweeView.setVisibility(8);
            bVar.p.f323b.setOnClickListener(new defpackage.e(2, bVar, attachment));
            return;
        }
        boolean spoiler = attachment.getSpoiler();
        View view = bVar.p.d;
        m.checkNotNullExpressionValue(view, "binding.attachmentSpoilerCover");
        view.setVisibility(spoiler ? 0 : 8);
        SimpleDraweeView simpleDraweeView2 = bVar.p.e;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentSpoilerIcon");
        simpleDraweeView2.setVisibility(spoiler ? 0 : 8);
        bVar.p.c.setOnClickListener(new defpackage.e(0, bVar, attachment));
        bVar.p.f323b.setOnClickListener(new defpackage.e(1, bVar, attachment));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewFindViewById;
        m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.g.view_attachment_preview_item, viewGroup, false);
        int i2 = R.f.attachment_item;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
        if (simpleDraweeView != null) {
            i2 = R.f.attachment_remove;
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView2 != null && (viewFindViewById = viewInflate.findViewById((i2 = R.f.attachment_spoiler_cover))) != null) {
                i2 = R.f.attachment_spoiler_icon;
                SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView3 != null) {
                    b.b.a.e.b bVar = new b.b.a.e.b((ConstraintLayout) viewInflate, simpleDraweeView, simpleDraweeView2, viewFindViewById, simpleDraweeView3);
                    m.checkNotNullExpressionValue(bVar, "ViewAttachmentPreviewIte….context), parent, false)");
                    return new b(this, bVar, this.onAttachmentSelected);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        b bVar = (b) viewHolder;
        m.checkNotNullParameter(bVar, "holder");
        super.onViewRecycled(bVar);
        bVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentPreviewAdapter(boolean z2, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2, Function1<? super AttachmentPreviewAdapter<T>, ? extends SelectionAggregator<T>> function1) {
        SelectionAggregator<T> selectionAggregatorInvoke;
        m.checkNotNullParameter(function2, "onAttachmentSelected");
        this.useBottomSheet = z2;
        this.onAttachmentSelected = function2;
        this.selectionAggregator = (function1 == null || (selectionAggregatorInvoke = function1.invoke(this)) == null) ? new SelectionAggregator<>(this, null, null, null, 14, null) : selectionAggregatorInvoke;
    }
}
