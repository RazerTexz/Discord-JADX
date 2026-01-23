package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDescription3 extends FunctionReferenceImpl implements Function1<View, WidgetHubDescriptionBinding> {
    public static final WidgetHubDescription3 INSTANCE = new WidgetHubDescription3();

    public WidgetHubDescription3() {
        super(1, WidgetHubDescriptionBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubDescriptionBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDescriptionBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.add_server;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.add_server);
        if (loadingButton != null) {
            i = C5419R.id.category;
            TextView textView = (TextView) view.findViewById(C5419R.id.category);
            if (textView != null) {
                i = C5419R.id.category_error;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.category_error);
                if (textView2 != null) {
                    i = C5419R.id.category_layout;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.category_layout);
                    if (linearLayout != null) {
                        i = C5419R.id.contact_sync_permissions_subtitle;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.contact_sync_permissions_subtitle);
                        if (textView3 != null) {
                            i = C5419R.id.description;
                            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C5419R.id.description);
                            if (textInputEditText != null) {
                                i = C5419R.id.description_layout;
                                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.description_layout);
                                if (textInputLayout != null) {
                                    i = C5419R.id.header;
                                    ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.header);
                                    if (screenTitleView != null) {
                                        return new WidgetHubDescriptionBinding((LinearLayout) view, loadingButton, textView, textView2, linearLayout, textView3, textInputEditText, textInputLayout, screenTitleView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
