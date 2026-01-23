package com.discord.widgets.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMainSurveyDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetMainSurveyDialog.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SURVEY_BODY = "extra_survey_body";
    private static final String EXTRA_SURVEY_ID = "extra_survey_id";
    private static final String EXTRA_SURVEY_TITLE = "extra_survey_title";
    private static final String EXTRA_SURVEY_URL = "extra_survey_url";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, String surveyId, String surveyUrl, String surveyBody, String surveyTitle) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(surveyId, "surveyId");
            Intrinsics3.checkNotNullParameter(surveyUrl, "surveyUrl");
            Intrinsics3.checkNotNullParameter(surveyBody, "surveyBody");
            Intrinsics3.checkNotNullParameter(surveyTitle, "surveyTitle");
            WidgetMainSurveyDialog widgetMainSurveyDialog = new WidgetMainSurveyDialog();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetMainSurveyDialog.EXTRA_SURVEY_ID, surveyId);
            bundle.putString(WidgetMainSurveyDialog.EXTRA_SURVEY_URL, surveyUrl);
            bundle.putString(WidgetMainSurveyDialog.EXTRA_SURVEY_BODY, surveyBody);
            bundle.putString(WidgetMainSurveyDialog.EXTRA_SURVEY_TITLE, surveyTitle);
            widgetMainSurveyDialog.setArguments(bundle);
            widgetMainSurveyDialog.show(fragmentManager, "WidgetMainSurveyDialog");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetMainSurveyDialog$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
    public static final class ViewOnClickListenerC89821 implements View.OnClickListener {
        public ViewOnClickListenerC89821() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMainSurveyDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetMainSurveyDialog$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
    public static final class ViewOnClickListenerC89832 implements View.OnClickListener {
        public final /* synthetic */ String $surveyUrl;

        public ViewOnClickListenerC89832(String str) {
            this.$surveyUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.m885x(view, "button", "button.context"), this.$surveyUrl, false, false, null, 28, null);
            WidgetMainSurveyDialog.this.dismiss();
        }
    }

    public WidgetMainSurveyDialog() {
        super(C5419R.layout.view_dialog_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMainSurveyDialog2.INSTANCE, null, 2, null);
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(EXTRA_SURVEY_URL) : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(EXTRA_SURVEY_BODY) : null;
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString(EXTRA_SURVEY_ID) : null;
        Bundle arguments4 = getArguments();
        String string4 = arguments4 != null ? arguments4.getString(EXTRA_SURVEY_TITLE) : null;
        if (!(string == null || string.length() == 0)) {
            if (!(string3 == null || string3.length() == 0)) {
                TextView textView = getBinding().f15423d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
                textView.setText(string4);
                TextView textView2 = getBinding().f15424e;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
                textView2.setText(string2);
                MaterialButton materialButton = getBinding().f15421b;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationCancel");
                materialButton.setText(getString(C5419R.string.no_thanks));
                getBinding().f15421b.setOnClickListener(new ViewOnClickListenerC89821());
                MaterialButton materialButton2 = getBinding().f15422c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationConfirm");
                materialButton2.setText(getString(C5419R.string.okay));
                getBinding().f15422c.setOnClickListener(new ViewOnClickListenerC89832(string));
                AnalyticsTracker.INSTANCE.surveyViewed(string3);
                return;
            }
        }
        dismiss();
    }
}
