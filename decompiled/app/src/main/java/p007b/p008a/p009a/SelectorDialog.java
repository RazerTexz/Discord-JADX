package p007b.p008a.p009a;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.DialogSimpleSelectorBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: SelectorDialog.kt */
/* renamed from: b.a.a.n, reason: use source file name */
/* loaded from: classes.dex */
public final class SelectorDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f410j = {outline.m846d0(SelectorDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onSelectedListener;

    /* renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final SelectorDialog m142a(FragmentManager fragmentManager, CharSequence charSequence, CharSequence[] charSequenceArr, Function1<? super Integer, Unit> function1) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(charSequence, "title");
            Intrinsics3.checkNotNullParameter(charSequenceArr, "options");
            Intrinsics3.checkNotNullParameter(function1, "onSelectedListener");
            SelectorDialog selectorDialog = new SelectorDialog();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("INTENT_DIALOG_TITLE", charSequence);
            bundle.putCharSequenceArray("INTENT_DIALOG_OPTIONS", charSequenceArr);
            selectorDialog.setArguments(bundle);
            selectorDialog.onSelectedListener = function1;
            selectorDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(SelectorDialog.class).toString());
            return selectorDialog;
        }
    }

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$b */
    public final class b extends SimpleRecyclerAdapter.ViewHolder<CharSequence> {

        /* renamed from: a */
        public final DialogSimpleSelectorItemBinding f414a;

        /* renamed from: b */
        public final /* synthetic */ SelectorDialog f415b;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(SelectorDialog selectorDialog, DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
            Intrinsics3.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
            this.f415b = selectorDialog;
            TextView textView = dialogSimpleSelectorItemBinding.f15039a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.f414a = dialogSimpleSelectorItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics3.checkNotNullParameter(charSequence2, "data");
            TextView textView = this.f414a.f15039a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            textView.setText(charSequence2);
            this.f414a.f15039a.setOnClickListener(new SelectorDialog2(this));
        }
    }

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, DialogSimpleSelectorBinding> {

        /* renamed from: j */
        public static final c f416j = new c();

        public c() {
            super(1, DialogSimpleSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public DialogSimpleSelectorBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.dialog_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.dialog_cancel);
            if (materialButton != null) {
                i = C5419R.id.dialog_selections;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(C5419R.id.dialog_selections);
                if (maxHeightRecyclerView != null) {
                    i = C5419R.id.dialog_title;
                    TextView textView = (TextView) view2.findViewById(C5419R.id.dialog_title);
                    if (textView != null) {
                        return new DialogSimpleSelectorBinding((LinearLayout) view2, materialButton, maxHeightRecyclerView, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$d */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SelectorDialog.this.dismiss();
        }
    }

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$e */
    public static final class e extends Lambda implements Function2<LayoutInflater, ViewGroup, b> {
        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public b invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            LayoutInflater layoutInflater2 = layoutInflater;
            ViewGroup viewGroup2 = viewGroup;
            Intrinsics3.checkNotNullParameter(layoutInflater2, "inflater");
            Intrinsics3.checkNotNullParameter(viewGroup2, "parent");
            DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingM8381a = DialogSimpleSelectorItemBinding.m8381a(layoutInflater2, viewGroup2, false);
            Intrinsics3.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingM8381a, "DialogSimpleSelectorItem…(inflater, parent, false)");
            return new b(SelectorDialog.this, dialogSimpleSelectorItemBindingM8381a);
        }
    }

    public SelectorDialog() {
        super(C5419R.layout.dialog_simple_selector);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.f416j, null, 2, null);
    }

    /* renamed from: g */
    public final DialogSimpleSelectorBinding m141g() {
        return (DialogSimpleSelectorBinding) this.binding.getValue((Fragment) this, f410j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = m141g().f1011d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dialogTitle");
        textView.setText(getArgumentsOrDefault().getCharSequence("INTENT_DIALOG_TITLE", null));
        m141g().f1009b.setOnClickListener(new d());
        CharSequence[] charSequenceArray = getArgumentsOrDefault().getCharSequenceArray("INTENT_DIALOG_OPTIONS");
        if (charSequenceArray != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = m141g().f1010c;
            Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.dialogSelections");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(_ArraysJvm.asList(charSequenceArray), new e()));
            MaxHeightRecyclerView maxHeightRecyclerView2 = m141g().f1010c;
            RecyclerView.Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            maxHeightRecyclerView2.setHasFixedSize(false);
            maxHeightRecyclerView2.setNestedScrollingEnabled(false);
            SimpleRecyclerAdapter.Companion companion = SimpleRecyclerAdapter.INSTANCE;
            MaxHeightRecyclerView maxHeightRecyclerView3 = m141g().f1010c;
            Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView3, "binding.dialogSelections");
            companion.addThemedDivider(maxHeightRecyclerView3);
        }
    }
}
