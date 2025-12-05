package com.discord.widgets.hubs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetHubEmailFlowBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.WidgetDiscordHubEmailInputBinding;
import p007b.p008a.p025i.WidgetHubEmailFlowConfirmationBinding;
import p007b.p008a.p025i.WidgetHubEmailFlowWaitlistBinding;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubEmailFlow.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubEmailFlow3 extends FunctionReferenceImpl implements Function1<View, WidgetHubEmailFlowBinding> {
    public static final WidgetHubEmailFlow3 INSTANCE = new WidgetHubEmailFlow3();

    public WidgetHubEmailFlow3() {
        super(1, WidgetHubEmailFlowBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubEmailFlowBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubEmailFlowBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubEmailFlowBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.discord_hub_email_button_layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.discord_hub_email_button_layout);
        if (linearLayout != null) {
            i = C5419R.id.discord_hub_email_confirmation;
            View viewFindViewById = view.findViewById(C5419R.id.discord_hub_email_confirmation);
            if (viewFindViewById != null) {
                int i2 = C5419R.id.discord_hub_email_confirmation_different;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById.findViewById(C5419R.id.discord_hub_email_confirmation_different);
                if (linkifiedTextView != null) {
                    i2 = C5419R.id.discord_hub_email_confirmation_header_title;
                    TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.discord_hub_email_confirmation_header_title);
                    if (textView != null) {
                        i2 = C5419R.id.discord_hub_email_confirmation_resend;
                        LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewFindViewById.findViewById(C5419R.id.discord_hub_email_confirmation_resend);
                        if (linkifiedTextView2 != null) {
                            WidgetHubEmailFlowConfirmationBinding widgetHubEmailFlowConfirmationBinding = new WidgetHubEmailFlowConfirmationBinding((NestedScrollView) viewFindViewById, linkifiedTextView, textView, linkifiedTextView2);
                            View viewFindViewById2 = view.findViewById(C5419R.id.discord_hub_email_input);
                            if (viewFindViewById2 != null) {
                                int i3 = C5419R.id.discord_hub_email_header_description;
                                LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) viewFindViewById2.findViewById(C5419R.id.discord_hub_email_header_description);
                                if (linkifiedTextView3 != null) {
                                    i3 = C5419R.id.discord_hub_email_header_description_email_input;
                                    TextInputEditText textInputEditText = (TextInputEditText) viewFindViewById2.findViewById(C5419R.id.discord_hub_email_header_description_email_input);
                                    if (textInputEditText != null) {
                                        i3 = C5419R.id.discord_hub_email_header_description_email_input_layout;
                                        TextInputLayout textInputLayout = (TextInputLayout) viewFindViewById2.findViewById(C5419R.id.discord_hub_email_header_description_email_input_layout);
                                        if (textInputLayout != null) {
                                            i3 = C5419R.id.discord_hub_email_header_image;
                                            ImageView imageView = (ImageView) viewFindViewById2.findViewById(C5419R.id.discord_hub_email_header_image);
                                            if (imageView != null) {
                                                i3 = C5419R.id.discord_hub_email_header_title;
                                                TextView textView2 = (TextView) viewFindViewById2.findViewById(C5419R.id.discord_hub_email_header_title);
                                                if (textView2 != null) {
                                                    i3 = C5419R.id.discord_hub_email_label;
                                                    TextView textView3 = (TextView) viewFindViewById2.findViewById(C5419R.id.discord_hub_email_label);
                                                    if (textView3 != null) {
                                                        WidgetDiscordHubEmailInputBinding widgetDiscordHubEmailInputBinding = new WidgetDiscordHubEmailInputBinding((NestedScrollView) viewFindViewById2, linkifiedTextView3, textInputEditText, textInputLayout, imageView, textView2, textView3);
                                                        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.discord_hub_email_no);
                                                        if (materialButton != null) {
                                                            LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.discord_hub_email_yes);
                                                            if (loadingButton != null) {
                                                                View viewFindViewById3 = view.findViewById(C5419R.id.discord_hub_waitlist);
                                                                if (viewFindViewById3 != null) {
                                                                    TextView textView4 = (TextView) viewFindViewById3.findViewById(C5419R.id.hub_waitlist_description);
                                                                    if (textView4 == null) {
                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(C5419R.id.hub_waitlist_description)));
                                                                    }
                                                                    return new WidgetHubEmailFlowBinding((LinearLayout) view, linearLayout, widgetHubEmailFlowConfirmationBinding, widgetDiscordHubEmailInputBinding, materialButton, loadingButton, new WidgetHubEmailFlowWaitlistBinding((NestedScrollView) viewFindViewById3, textView4));
                                                                }
                                                                i = C5419R.id.discord_hub_waitlist;
                                                            } else {
                                                                i = C5419R.id.discord_hub_email_yes;
                                                            }
                                                        } else {
                                                            i = C5419R.id.discord_hub_email_no;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i3)));
                            }
                            i = C5419R.id.discord_hub_email_input;
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
