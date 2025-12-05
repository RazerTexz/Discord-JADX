package com.lytefast.flexinput.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.drawable.DrawableCompat;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p000.ViewOnClickListenerC12252e;
import p007b.p076b.p077a.p079d.ThumbnailViewHolder;
import p007b.p076b.p077a.p080e.ViewAttachmentPreviewItemBinding;
import p007b.p109f.p132g.p133a.p134a.Fresco;
import p007b.p109f.p132g.p133a.p134a.PipelineDraweeControllerBuilder;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: AttachmentPreviewAdapter.kt */
/* loaded from: classes3.dex */
public final class AttachmentPreviewAdapter<T extends Attachment<? extends Object>> extends RecyclerView.Adapter<AttachmentPreviewAdapter<T>.C11172b> {

    /* renamed from: a, reason: from kotlin metadata */
    public final SelectionAggregator<T> selectionAggregator;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean useBottomSheet;

    /* renamed from: c, reason: from kotlin metadata */
    public final Function2<SelectionAggregator<T>, T, Unit> onAttachmentSelected;

    /* compiled from: AttachmentPreviewAdapter.kt */
    /* renamed from: com.lytefast.flexinput.adapters.AttachmentPreviewAdapter$a */
    public static final class C11171a extends Lambda implements Function2<SelectionAggregator<T>, T, Unit> {

        /* renamed from: j */
        public static final C11171a f22017j = new C11171a();

        public C11171a() {
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Object obj, Object obj2) {
            SelectionAggregator selectionAggregator = (SelectionAggregator) obj;
            Attachment attachment = (Attachment) obj2;
            Intrinsics3.checkNotNullParameter(selectionAggregator, "aggregator");
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            selectionAggregator.unselectItem(attachment);
            return Unit.f27425a;
        }
    }

    /* compiled from: AttachmentPreviewAdapter.kt */
    /* renamed from: com.lytefast.flexinput.adapters.AttachmentPreviewAdapter$b */
    public final class C11172b extends ThumbnailViewHolder {

        /* renamed from: p */
        public final ViewAttachmentPreviewItemBinding f22018p;

        /* renamed from: q */
        public final Function2<SelectionAggregator<T>, T, Unit> f22019q;

        /* renamed from: r */
        public final /* synthetic */ AttachmentPreviewAdapter f22020r;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public C11172b(AttachmentPreviewAdapter attachmentPreviewAdapter, ViewAttachmentPreviewItemBinding viewAttachmentPreviewItemBinding, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2) {
            Intrinsics3.checkNotNullParameter(viewAttachmentPreviewItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function2, "onAttachmentSelected");
            this.f22020r = attachmentPreviewAdapter;
            ConstraintLayout constraintLayout = viewAttachmentPreviewItemBinding.f2189a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout);
            this.f22018p = viewAttachmentPreviewItemBinding;
            this.f22019q = function2;
            GenericDraweeHierarchy hierarchy = mo401a().getHierarchy();
            Context context = mo401a().getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "imageView.context");
            hierarchy.m8680p(DrawableCompat.getThemedDrawableRes$default(context, C11170R.b.ic_flex_input_file, 0, 2, (Object) null));
        }

        @Override // p007b.p076b.p077a.p079d.ThumbnailViewHolder
        /* renamed from: a */
        public SimpleDraweeView mo401a() {
            SimpleDraweeView simpleDraweeView = this.f22018p.f2190b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentItem");
            return simpleDraweeView;
        }
    }

    public AttachmentPreviewAdapter() {
        this(false, null, null, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AttachmentPreviewAdapter(boolean z2, Function2 function2, Function1 function1, int i) {
        z2 = (i & 1) != 0 ? false : z2;
        C11171a c11171a = (i & 2) != 0 ? C11171a.f22017j : null;
        int i2 = i & 4;
        this(z2, c11171a, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.selectionAggregator.getSize();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        C11172b c11172b = (C11172b) viewHolder;
        Intrinsics3.checkNotNullParameter(c11172b, "holder");
        Attachment attachment = this.selectionAggregator.get(i);
        Objects.requireNonNull(c11172b);
        Intrinsics3.checkNotNullParameter(attachment, "item");
        if (attachment instanceof Media) {
            c11172b.mo401a().setController(null);
            c11172b.m405c((Media) attachment, null, null);
        } else {
            int dimensionPixelSize = c11172b.mo401a().getResources().getDimensionPixelSize(C11170R.d.attachment_preview_dimen);
            ImageRequestBuilder imageRequestBuilderM8723b = ImageRequestBuilder.m8723b(attachment.getUri());
            imageRequestBuilderM8723b.f19616e = RotationOptions.f3721a;
            imageRequestBuilderM8723b.f19615d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderM1037a = Fresco.m1037a();
            pipelineDraweeControllerBuilderM1037a.f19490n = c11172b.mo401a().getController();
            pipelineDraweeControllerBuilderM1037a.f19489m = true;
            pipelineDraweeControllerBuilderM1037a.f19484h = imageRequestBuilderM8723b.m8724a();
            c11172b.mo401a().setController(pipelineDraweeControllerBuilderM1037a.m8667a());
        }
        if (!c11172b.f22020r.useBottomSheet) {
            SimpleDraweeView simpleDraweeView = c11172b.f22018p.f2191c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentRemove");
            simpleDraweeView.setVisibility(8);
            c11172b.f22018p.f2190b.setOnClickListener(new ViewOnClickListenerC12252e(2, c11172b, attachment));
            return;
        }
        boolean spoiler = attachment.getSpoiler();
        View view = c11172b.f22018p.f2192d;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.attachmentSpoilerCover");
        view.setVisibility(spoiler ? 0 : 8);
        SimpleDraweeView simpleDraweeView2 = c11172b.f22018p.f2193e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentSpoilerIcon");
        simpleDraweeView2.setVisibility(spoiler ? 0 : 8);
        c11172b.f22018p.f2191c.setOnClickListener(new ViewOnClickListenerC12252e(0, c11172b, attachment));
        c11172b.f22018p.f2190b.setOnClickListener(new ViewOnClickListenerC12252e(1, c11172b, attachment));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewFindViewById;
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C11170R.g.view_attachment_preview_item, viewGroup, false);
        int i2 = C11170R.f.attachment_item;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
        if (simpleDraweeView != null) {
            i2 = C11170R.f.attachment_remove;
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView2 != null && (viewFindViewById = viewInflate.findViewById((i2 = C11170R.f.attachment_spoiler_cover))) != null) {
                i2 = C11170R.f.attachment_spoiler_icon;
                SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView3 != null) {
                    ViewAttachmentPreviewItemBinding viewAttachmentPreviewItemBinding = new ViewAttachmentPreviewItemBinding((ConstraintLayout) viewInflate, simpleDraweeView, simpleDraweeView2, viewFindViewById, simpleDraweeView3);
                    Intrinsics3.checkNotNullExpressionValue(viewAttachmentPreviewItemBinding, "ViewAttachmentPreviewIte….context), parent, false)");
                    return new C11172b(this, viewAttachmentPreviewItemBinding, this.onAttachmentSelected);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        C11172b c11172b = (C11172b) viewHolder;
        Intrinsics3.checkNotNullParameter(c11172b, "holder");
        super.onViewRecycled(c11172b);
        c11172b.m404b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentPreviewAdapter(boolean z2, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2, Function1<? super AttachmentPreviewAdapter<T>, ? extends SelectionAggregator<T>> function1) {
        SelectionAggregator<T> selectionAggregatorInvoke;
        Intrinsics3.checkNotNullParameter(function2, "onAttachmentSelected");
        this.useBottomSheet = z2;
        this.onAttachmentSelected = function2;
        this.selectionAggregator = (function1 == null || (selectionAggregatorInvoke = function1.invoke(this)) == null) ? new SelectionAggregator<>(this, null, null, null, 14, null) : selectionAggregatorInvoke;
    }
}
