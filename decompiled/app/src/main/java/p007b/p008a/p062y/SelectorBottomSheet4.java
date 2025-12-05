package p007b.p008a.p062y;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import p007b.p008a.p025i.BottomSheetSimpleSelectorItemBinding;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SelectorBottomSheet.kt */
/* renamed from: b.a.y.e0, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectorBottomSheet4 extends SimpleRecyclerAdapter.ViewHolder<SelectorBottomSheet2> {

    /* renamed from: a */
    public final SelectorBottomSheet5 f2018a;

    /* renamed from: b */
    public final DialogInterface f2019b;

    /* renamed from: c */
    public final BottomSheetSimpleSelectorItemBinding f2020c;

    /* JADX WARN: Illegal instructions before constructor call */
    public SelectorBottomSheet4(SelectorBottomSheet5 selectorBottomSheet5, DialogInterface dialogInterface, BottomSheetSimpleSelectorItemBinding bottomSheetSimpleSelectorItemBinding) {
        Intrinsics3.checkNotNullParameter(selectorBottomSheet5, "onSelectedListener");
        Intrinsics3.checkNotNullParameter(dialogInterface, "dialogInterface");
        Intrinsics3.checkNotNullParameter(bottomSheetSimpleSelectorItemBinding, "itemBinding");
        ConstraintLayout constraintLayout = bottomSheetSimpleSelectorItemBinding.f761a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "itemBinding.root");
        super(constraintLayout);
        this.f2018a = selectorBottomSheet5;
        this.f2019b = dialogInterface;
        this.f2020c = bottomSheetSimpleSelectorItemBinding;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bind(SelectorBottomSheet2 selectorBottomSheet2) {
        int themedColor;
        Drawable drawable;
        SelectorBottomSheet2 selectorBottomSheet22 = selectorBottomSheet2;
        Intrinsics3.checkNotNullParameter(selectorBottomSheet22, "data");
        MaterialTextView materialTextView = this.f2020c.f764d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "itemBinding.selectComponentSheetItemTitle");
        FormatUtils.m209a(materialTextView, selectorBottomSheet22.m384e());
        MaterialTextView materialTextView2 = this.f2020c.f762b;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "itemBinding.selectComponentSheetItemDescription");
        ViewExtensions.setTextAndVisibilityBy(materialTextView2, selectorBottomSheet22.m380a());
        SimpleDraweeView simpleDraweeView = this.f2020c.f763c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.selectComponentSheetItemIcon");
        simpleDraweeView.setVisibility(selectorBottomSheet22.m383d() != null || selectorBottomSheet22.m381b() != null ? 0 : 8);
        String strM383d = selectorBottomSheet22.m383d();
        if (strM383d != null) {
            SimpleDraweeView simpleDraweeView2 = this.f2020c.f763c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.selectComponentSheetItemIcon");
            MGImages.setImage$default(simpleDraweeView2, strM383d, C5419R.dimen.emoji_size, C5419R.dimen.emoji_size, true, null, null, 96, null);
        } else {
            Integer numM381b = selectorBottomSheet22.m381b();
            if (numM381b != null) {
                this.f2020c.f763c.setImageResource(numM381b.intValue());
            }
        }
        Integer numM382c = selectorBottomSheet22.m382c();
        if (numM382c != null) {
            this.f2020c.f763c.setColorFilter(numM382c.intValue());
        }
        MaterialTextView materialTextView3 = this.f2020c.f764d;
        materialTextView3.setText(selectorBottomSheet22.m384e());
        Integer numM386g = selectorBottomSheet22.m386g();
        if (numM386g != null) {
            themedColor = numM386g.intValue();
        } else {
            Intrinsics3.checkNotNullExpressionValue(materialTextView3, "this");
            themedColor = ColorCompat.getThemedColor(materialTextView3, C5419R.attr.colorHeaderPrimary);
        }
        materialTextView3.setTextColor(themedColor);
        Integer numM385f = selectorBottomSheet22.m385f();
        if (numM385f != null) {
            numM385f.intValue();
            Drawable drawable2 = ContextCompat.getDrawable(materialTextView3.getContext(), selectorBottomSheet22.m385f().intValue());
            if (drawable2 != null) {
                MaterialTextView materialTextView4 = this.f2020c.f764d;
                Intrinsics3.checkNotNullExpressionValue(materialTextView4, "itemBinding.selectComponentSheetItemTitle");
                DrawableCompat.setTint(drawable2, ColorCompat.getThemedColor(materialTextView4, C5419R.attr.colorHeaderPrimary));
                drawable = drawable2;
            } else {
                drawable = null;
            }
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(materialTextView3, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
        this.f2020c.f761a.setOnClickListener(new SelectorBottomSheet3(this));
    }
}
