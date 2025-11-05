package b.a.y;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import java.io.Serializable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: SelectorBottomSheet.kt */
/* loaded from: classes2.dex */
public final class b0 extends AppBottomSheet implements i {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(b0.class, "binding", "getBinding()Lcom/discord/databinding/BottomSheetSimpleSelectorBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onSelectedListener;

    /* renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: SelectorBottomSheet.kt */
    /* renamed from: b.a.y.b0$a, reason: from kotlin metadata */
    public static final class Companion {

        /* compiled from: SelectorBottomSheet.kt */
        /* renamed from: b.a.y.b0$a$a, reason: collision with other inner class name */
        public static final class C0057a extends d0.z.d.o implements Function1<Integer, Unit> {
            public static final C0057a j = new C0057a();

            public C0057a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                num.intValue();
                return Unit.a;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static /* synthetic */ b0 b(Companion companion, FragmentManager fragmentManager, String str, List list, boolean z2, Function1 function1, int i) {
            boolean z3 = (i & 8) != 0 ? true : z2;
            if ((i & 16) != 0) {
                function1 = C0057a.j;
            }
            return companion.a(fragmentManager, str, list, z3, function1);
        }

        public final b0 a(FragmentManager fragmentManager, String str, List<c0> list, boolean z2, Function1<? super Integer, Unit> function1) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            d0.z.d.m.checkNotNullParameter(str, "title");
            d0.z.d.m.checkNotNullParameter(list, "options");
            d0.z.d.m.checkNotNullParameter(function1, "onSelectedListener");
            b0 b0Var = new b0();
            b0Var.setArguments(BundleKt.bundleOf(d0.o.to("simple_bottom_sheet_title", str), d0.o.to("simple_bottom_sheet_options", list), d0.o.to("simple_bottom_sheet_show_dividers", Boolean.valueOf(z2))));
            b0Var.onSelectedListener = function1;
            b0Var.show(fragmentManager, d0.z.d.a0.getOrCreateKotlinClass(b0.class).toString());
            return b0Var;
        }
    }

    /* compiled from: SelectorBottomSheet.kt */
    public static final /* synthetic */ class b extends d0.z.d.k implements Function1<View, b.a.i.c> {
        public static final b j = new b();

        public b() {
            super(1, b.a.i.c.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/BottomSheetSimpleSelectorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.a.i.c invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.widget_simple_bottom_sheet_selector_header;
            ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R.id.widget_simple_bottom_sheet_selector_header);
            if (constraintLayout != null) {
                i = R.id.widget_simple_bottom_sheet_selector_placeholder;
                TextView textView = (TextView) view2.findViewById(R.id.widget_simple_bottom_sheet_selector_placeholder);
                if (textView != null) {
                    i = R.id.widget_simple_bottom_sheet_selector_recycler;
                    MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(R.id.widget_simple_bottom_sheet_selector_recycler);
                    if (maxHeightRecyclerView != null) {
                        return new b.a.i.c((ConstraintLayout) view2, constraintLayout, textView, maxHeightRecyclerView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: SelectorBottomSheet.kt */
    public static final class c extends d0.z.d.o implements Function2<LayoutInflater, ViewGroup, e0> {
        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public e0 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            LayoutInflater layoutInflater2 = layoutInflater;
            ViewGroup viewGroup2 = viewGroup;
            d0.z.d.m.checkNotNullParameter(layoutInflater2, "inflater");
            d0.z.d.m.checkNotNullParameter(viewGroup2, "parent");
            View viewInflate = layoutInflater2.inflate(R.layout.bottom_sheet_simple_selector_item, viewGroup2, false);
            int i = R.id.select_component_sheet_item_description;
            MaterialTextView materialTextView = (MaterialTextView) viewInflate.findViewById(R.id.select_component_sheet_item_description);
            if (materialTextView != null) {
                i = R.id.select_component_sheet_item_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.select_component_sheet_item_icon);
                if (simpleDraweeView != null) {
                    i = R.id.select_component_sheet_item_title;
                    MaterialTextView materialTextView2 = (MaterialTextView) viewInflate.findViewById(R.id.select_component_sheet_item_title);
                    if (materialTextView2 != null) {
                        b.a.i.d dVar = new b.a.i.d((ConstraintLayout) viewInflate, materialTextView, simpleDraweeView, materialTextView2);
                        d0.z.d.m.checkNotNullExpressionValue(dVar, "BottomSheetSimpleSelecto…(inflater, parent, false)");
                        b0 b0Var = b0.this;
                        Dialog dialogRequireDialog = b0Var.requireDialog();
                        d0.z.d.m.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
                        return new e0(b0Var, dialogRequireDialog, dVar);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }

    public b0() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
    }

    @Override // b.a.y.i
    public void c(int position) {
        Function1<? super Integer, Unit> function1 = this.onSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(position));
        }
    }

    public final b.a.i.c g() {
        return (b.a.i.c) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.bottom_sheet_simple_selector;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        d0.z.d.m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.onSelectedListener = null;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        String string = getArgumentsOrDefault().getString("simple_bottom_sheet_title");
        Serializable serializable = getArgumentsOrDefault().getSerializable("simple_bottom_sheet_options");
        if (!(serializable instanceof List)) {
            serializable = null;
        }
        List list = (List) serializable;
        boolean z2 = getArgumentsOrDefault().getBoolean("simple_bottom_sheet_show_dividers");
        TextView textView = g().c;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.widgetSimpleBottomSheetSelectorPlaceholder");
        textView.setText(string);
        ConstraintLayout constraintLayout = g().f88b;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.widgetSimpleBottomSheetSelectorHeader");
        constraintLayout.setVisibility((string == null || string.length() == 0) ^ true ? 0 : 8);
        if (list != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = g().d;
            d0.z.d.m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSimpleBottomSheetSelectorRecycler");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(list, new c()));
            MaxHeightRecyclerView maxHeightRecyclerView2 = g().d;
            RecyclerView.Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            if (z2) {
                SimpleRecyclerAdapter.INSTANCE.addThemedDivider(maxHeightRecyclerView2);
            }
        }
    }
}
