package b.a.a;

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
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: SelectorDialog.kt */
/* loaded from: classes.dex */
public final class n extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(n.class, "binding", "getBinding()Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0)};

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

        public final n a(FragmentManager fragmentManager, CharSequence charSequence, CharSequence[] charSequenceArr, Function1<? super Integer, Unit> function1) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            d0.z.d.m.checkNotNullParameter(charSequence, "title");
            d0.z.d.m.checkNotNullParameter(charSequenceArr, "options");
            d0.z.d.m.checkNotNullParameter(function1, "onSelectedListener");
            n nVar = new n();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("INTENT_DIALOG_TITLE", charSequence);
            bundle.putCharSequenceArray("INTENT_DIALOG_OPTIONS", charSequenceArr);
            nVar.setArguments(bundle);
            nVar.onSelectedListener = function1;
            nVar.show(fragmentManager, a0.getOrCreateKotlinClass(n.class).toString());
            return nVar;
        }
    }

    /* compiled from: SelectorDialog.kt */
    public final class b extends SimpleRecyclerAdapter.ViewHolder<CharSequence> {
        public final DialogSimpleSelectorItemBinding a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f49b;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(n nVar, DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
            d0.z.d.m.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
            this.f49b = nVar;
            TextView textView = dialogSimpleSelectorItemBinding.a;
            d0.z.d.m.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.a = dialogSimpleSelectorItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            d0.z.d.m.checkNotNullParameter(charSequence2, "data");
            TextView textView = this.a.a;
            d0.z.d.m.checkNotNullExpressionValue(textView, "binding.root");
            textView.setText(charSequence2);
            this.a.a.setOnClickListener(new o(this));
        }
    }

    /* compiled from: SelectorDialog.kt */
    public static final /* synthetic */ class c extends d0.z.d.k implements Function1<View, b.a.i.l> {
        public static final c j = new c();

        public c() {
            super(1, b.a.i.l.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.a.i.l invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.dialog_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.dialog_cancel);
            if (materialButton != null) {
                i = R.id.dialog_selections;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(R.id.dialog_selections);
                if (maxHeightRecyclerView != null) {
                    i = R.id.dialog_title;
                    TextView textView = (TextView) view2.findViewById(R.id.dialog_title);
                    if (textView != null) {
                        return new b.a.i.l((LinearLayout) view2, materialButton, maxHeightRecyclerView, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: SelectorDialog.kt */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n.this.dismiss();
        }
    }

    /* compiled from: SelectorDialog.kt */
    public static final class e extends d0.z.d.o implements Function2<LayoutInflater, ViewGroup, b> {
        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public b invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            LayoutInflater layoutInflater2 = layoutInflater;
            ViewGroup viewGroup2 = viewGroup;
            d0.z.d.m.checkNotNullParameter(layoutInflater2, "inflater");
            d0.z.d.m.checkNotNullParameter(viewGroup2, "parent");
            DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingA = DialogSimpleSelectorItemBinding.a(layoutInflater2, viewGroup2, false);
            d0.z.d.m.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingA, "DialogSimpleSelectorItem…(inflater, parent, false)");
            return new b(n.this, dialogSimpleSelectorItemBindingA);
        }
    }

    public n() {
        super(R.layout.dialog_simple_selector);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);
    }

    public final b.a.i.l g() {
        return (b.a.i.l) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) throws Resources.NotFoundException {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = g().d;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.dialogTitle");
        textView.setText(getArgumentsOrDefault().getCharSequence("INTENT_DIALOG_TITLE", null));
        g().f149b.setOnClickListener(new d());
        CharSequence[] charSequenceArray = getArgumentsOrDefault().getCharSequenceArray("INTENT_DIALOG_OPTIONS");
        if (charSequenceArray != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = g().c;
            d0.z.d.m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.dialogSelections");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(d0.t.j.asList(charSequenceArray), new e()));
            MaxHeightRecyclerView maxHeightRecyclerView2 = g().c;
            RecyclerView.Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            maxHeightRecyclerView2.setHasFixedSize(false);
            maxHeightRecyclerView2.setNestedScrollingEnabled(false);
            SimpleRecyclerAdapter.Companion companion = SimpleRecyclerAdapter.INSTANCE;
            MaxHeightRecyclerView maxHeightRecyclerView3 = g().c;
            d0.z.d.m.checkNotNullExpressionValue(maxHeightRecyclerView3, "binding.dialogSelections");
            companion.addThemedDivider(maxHeightRecyclerView3);
        }
    }
}
