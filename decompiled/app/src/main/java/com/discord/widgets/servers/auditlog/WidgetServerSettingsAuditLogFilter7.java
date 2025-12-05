package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuditLogFilterBinding;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLogFilter7 extends FunctionReferenceImpl implements Function1<View, WidgetAuditLogFilterBinding> {
    public static final WidgetServerSettingsAuditLogFilter7 INSTANCE = new WidgetServerSettingsAuditLogFilter7();

    public WidgetServerSettingsAuditLogFilter7() {
        super(1, WidgetAuditLogFilterBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuditLogFilterBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuditLogFilterBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuditLogFilterBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.audit_log_filter_input;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.audit_log_filter_input);
        if (textInputLayout != null) {
            i = C5419R.id.audit_log_filter_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.audit_log_filter_recycler);
            if (recyclerView != null) {
                return new WidgetAuditLogFilterBinding((LinearLayout) view, textInputLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
