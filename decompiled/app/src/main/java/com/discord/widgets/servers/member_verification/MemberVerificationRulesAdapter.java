package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMemberVerificationApproveTermsItemBinding;
import com.discord.databinding.WidgetMemberVerificationHeaderItemBinding;
import com.discord.databinding.WidgetMemberVerificationMultipleChoiceItemBinding;
import com.discord.databinding.WidgetMemberVerificationParagraphItemBinding;
import com.discord.databinding.WidgetMemberVerificationRuleItemBinding;
import com.discord.databinding.WidgetMemberVerificationTextInputItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemMultipleChoice;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemParagraph;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTerm;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTextInput;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.WidgetMemberVerificationMultipleChoiceRadioItemBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: MemberVerificationRulesAdapter.kt */
/* loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private final AppFragment fragment;
    private Function1<? super Boolean, Unit> onUpdateRulesApproval;
    private Function2<? super Integer, Object, Unit> onUserInputDataEntered;

    /* compiled from: MemberVerificationRulesAdapter.kt */
    public static final class ApproveTermsItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationApproveTermsItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApproveTermsItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(C5419R.layout.widget_member_verification_approve_terms_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            CheckedSetting checkedSetting = (CheckedSetting) view;
            WidgetMemberVerificationApproveTermsItemBinding widgetMemberVerificationApproveTermsItemBinding = new WidgetMemberVerificationApproveTermsItemBinding(checkedSetting, checkedSetting);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationApproveTermsItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationApproveTermsItemBinding;
        }

        public static final /* synthetic */ MemberVerificationRulesAdapter access$getAdapter$p(ApproveTermsItemHolder approveTermsItemHolder) {
            return (MemberVerificationRulesAdapter) approveTermsItemHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemApproveTerms memberVerificationItemApproveTerms = (MemberVerificationItemApproveTerms) data;
            CheckedSetting checkedSetting = this.binding.f17236b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.memberVerificationRulesCheck");
            checkedSetting.setChecked(memberVerificationItemApproveTerms.isApproved());
            this.binding.f17236b.m8527e(new MemberVerificationRulesAdapter2(this, memberVerificationItemApproveTerms));
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    public static final class ItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(C5419R.layout.widget_member_verification_header_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetMemberVerificationHeaderItemBinding widgetMemberVerificationHeaderItemBinding = new WidgetMemberVerificationHeaderItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationHeaderItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f17245b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRulesHeader");
            textView.setText(((MemberVerificationItemHeader) data).getTitle());
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    public static final class MultipleChoiceItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationMultipleChoiceItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultipleChoiceItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(C5419R.layout.widget_member_verification_multiple_choice_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            RadioGroup radioGroup = (RadioGroup) view;
            WidgetMemberVerificationMultipleChoiceItemBinding widgetMemberVerificationMultipleChoiceItemBinding = new WidgetMemberVerificationMultipleChoiceItemBinding(radioGroup, radioGroup);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationMultipleChoiceItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationMultipleChoiceItemBinding;
        }

        public static final /* synthetic */ MemberVerificationRulesAdapter access$getAdapter$p(MultipleChoiceItemHolder multipleChoiceItemHolder) {
            return (MemberVerificationRulesAdapter) multipleChoiceItemHolder.adapter;
        }

        private final void createMultipleChoiceButtons(Context context, RadioGroup radioGroup, List<String> valueList, Function1<? super Integer, Unit> onItemSelected) {
            RadioButton radioButton;
            for (String str : valueList) {
                int iIndexOf = valueList.indexOf(str);
                if (iIndexOf >= radioGroup.getChildCount()) {
                    View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.widget_member_verification_multiple_choice_radio_item, (ViewGroup) radioGroup, false);
                    Objects.requireNonNull(viewInflate, "rootView");
                    radioButton = (RadioButton) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new WidgetMemberVerificationMultipleChoiceRadioItemBinding(radioButton), "WidgetMemberVerification…        false\n          )");
                    Intrinsics3.checkNotNullExpressionValue(radioButton, "WidgetMemberVerification…   false\n          ).root");
                    radioGroup.addView(radioButton);
                } else {
                    View childAt = this.binding.f17247b.getChildAt(iIndexOf);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                    radioButton = (RadioButton) childAt;
                }
                RadioButton radioButton2 = radioButton;
                radioButton2.setText(str);
                radioButton2.setOnCheckedChangeListener(new MemberVerificationRulesAdapter3(iIndexOf, this, valueList, radioGroup, context, onItemSelected));
            }
            int childCount = radioGroup.getChildCount();
            for (int size = valueList.size(); size < childCount; size++) {
                View childAt2 = this.binding.f17247b.getChildAt(size);
                Intrinsics3.checkNotNullExpressionValue(childAt2, "radioButton");
                childAt2.setVisibility(8);
            }
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemMultipleChoice memberVerificationItemMultipleChoice = (MemberVerificationItemMultipleChoice) data;
            Integer response = memberVerificationItemMultipleChoice.getResponse();
            Context contextM885x = outline.m885x(this.itemView, "itemView", "itemView.context");
            RadioGroup radioGroup = this.binding.f17247b;
            Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.memberVerificationMultipleChoiceRadioGroup");
            createMultipleChoiceButtons(contextM885x, radioGroup, memberVerificationItemMultipleChoice.getChoices(), new MemberVerificationRulesAdapter4(this, data));
            if (response != null) {
                View childAt = this.binding.f17247b.getChildAt(response.intValue());
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                ((RadioButton) childAt).setChecked(true);
            }
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    public static final class ParagraphItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationParagraphItemBinding binding;
        private int fieldIndex;

        /* compiled from: MemberVerificationRulesAdapter.kt */
        /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$ParagraphItemHolder$1 */
        public static final class C95481 extends Lambda implements Function1<Editable, Unit> {
            public final /* synthetic */ MemberVerificationRulesAdapter $adapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C95481(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
                super(1);
                this.$adapter = memberVerificationRulesAdapter;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Editable editable) {
                Intrinsics3.checkNotNullParameter(editable, "editable");
                this.$adapter.getOnUserInputDataEntered().invoke(Integer.valueOf(ParagraphItemHolder.access$getFieldIndex$p(ParagraphItemHolder.this)), editable.toString());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParagraphItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(C5419R.layout.widget_member_verification_paragraph_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C5419R.id.member_verification_paragraph_field);
            if (textInputEditText == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.member_verification_paragraph_field)));
            }
            WidgetMemberVerificationParagraphItemBinding widgetMemberVerificationParagraphItemBinding = new WidgetMemberVerificationParagraphItemBinding((TextInputLayout) view, textInputEditText);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationParagraphItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationParagraphItemBinding;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.memberVerificationParagraphField");
            TextWatcher4.addBindedTextWatcher(textInputEditText, memberVerificationRulesAdapter.getFragment(), new C95481(memberVerificationRulesAdapter));
        }

        public static final /* synthetic */ int access$getFieldIndex$p(ParagraphItemHolder paragraphItemHolder) {
            return paragraphItemHolder.fieldIndex;
        }

        public static final /* synthetic */ void access$setFieldIndex$p(ParagraphItemHolder paragraphItemHolder, int i) {
            paragraphItemHolder.fieldIndex = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemParagraph memberVerificationItemParagraph = (MemberVerificationItemParagraph) data;
            this.fieldIndex = memberVerificationItemParagraph.getFieldIndex();
            this.binding.f17249b.setText(memberVerificationItemParagraph.getResponse());
            TextInputEditText textInputEditText = this.binding.f17249b;
            String response = memberVerificationItemParagraph.getResponse();
            textInputEditText.setSelection(response != null ? response.length() : 0);
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    public static final class TermHeaderItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TermHeaderItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(C5419R.layout.widget_member_verification_header_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetMemberVerificationHeaderItemBinding widgetMemberVerificationHeaderItemBinding = new WidgetMemberVerificationHeaderItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationHeaderItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f17245b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRulesHeader");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            textView.setText(view.getResources().getString(C5419R.string.member_verification_form_rules_label));
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    public static final class TermItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationRuleItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TermItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(C5419R.layout.widget_member_verification_rule_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.member_verification_rule_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.member_verification_rule_container);
            if (linearLayout != null) {
                i = C5419R.id.member_verification_rule_description;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(C5419R.id.member_verification_rule_description);
                if (simpleDraweeSpanTextView != null) {
                    i = C5419R.id.member_verification_rule_divider;
                    View viewFindViewById = view.findViewById(C5419R.id.member_verification_rule_divider);
                    if (viewFindViewById != null) {
                        i = C5419R.id.member_verification_rule_index;
                        TextView textView = (TextView) view.findViewById(C5419R.id.member_verification_rule_index);
                        if (textView != null) {
                            RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) view;
                            WidgetMemberVerificationRuleItemBinding widgetMemberVerificationRuleItemBinding = new WidgetMemberVerificationRuleItemBinding(roundedRelativeLayout, linearLayout, simpleDraweeSpanTextView, viewFindViewById, textView, roundedRelativeLayout);
                            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationRuleItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
                            this.binding = widgetMemberVerificationRuleItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemTerm memberVerificationItemTerm = (MemberVerificationItemTerm) data;
            TextView textView = this.binding.f17260d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRuleIndex");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            Resources resources = view.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
            int index = memberVerificationItemTerm.getIndex();
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            textView.setText(FormatUtils.m217i(resources, C5419R.string.member_verification_rule_index, new Object[]{StringUtils2.format(index, context)}, null, 4));
            this.binding.f17258b.setDraweeSpanStringBuilder(AstRenderer.render(memberVerificationItemTerm.getAst(), new MessageRenderContext(outline.m885x(this.itemView, "itemView", "itemView.context"), 0L, memberVerificationItemTerm.getAllowAnimatedEmojis(), null, memberVerificationItemTerm.getChannelNames(), memberVerificationItemTerm.getRoles(), 0, null, null, 0, 0, null, null, null, 16328, null)));
            View view3 = this.binding.f17259c;
            Intrinsics3.checkNotNullExpressionValue(view3, "binding.memberVerificationRuleDivider");
            view3.setVisibility(memberVerificationItemTerm.isLastItem() ^ true ? 0 : 8);
            float fDpToPixels = DimenUtils.dpToPixels(4);
            if (memberVerificationItemTerm.isFirstItem()) {
                this.binding.f17261e.updateTopLeftRadius(fDpToPixels);
                this.binding.f17261e.updateTopRightRadius(fDpToPixels);
            }
            if (memberVerificationItemTerm.isLastItem()) {
                this.binding.f17261e.updateBottomLeftRadius(fDpToPixels);
                this.binding.f17261e.updateBottomRightRadius(fDpToPixels);
            }
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    public static final class TextInputItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationTextInputItemBinding binding;
        private int fieldIndex;

        /* compiled from: MemberVerificationRulesAdapter.kt */
        /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$TextInputItemHolder$1 */
        public static final class C95491 extends Lambda implements Function1<Editable, Unit> {
            public final /* synthetic */ MemberVerificationRulesAdapter $adapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C95491(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
                super(1);
                this.$adapter = memberVerificationRulesAdapter;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Editable editable) {
                Intrinsics3.checkNotNullParameter(editable, "editable");
                this.$adapter.getOnUserInputDataEntered().invoke(Integer.valueOf(TextInputItemHolder.access$getFieldIndex$p(TextInputItemHolder.this)), editable.toString());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextInputItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(C5419R.layout.widget_member_verification_text_input_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C5419R.id.member_verification_text_input_field);
            if (textInputEditText == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.member_verification_text_input_field)));
            }
            WidgetMemberVerificationTextInputItemBinding widgetMemberVerificationTextInputItemBinding = new WidgetMemberVerificationTextInputItemBinding((TextInputLayout) view, textInputEditText);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationTextInputItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationTextInputItemBinding;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.memberVerificationTextInputField");
            TextWatcher4.addBindedTextWatcher(textInputEditText, memberVerificationRulesAdapter.getFragment(), new C95491(memberVerificationRulesAdapter));
        }

        public static final /* synthetic */ int access$getFieldIndex$p(TextInputItemHolder textInputItemHolder) {
            return textInputItemHolder.fieldIndex;
        }

        public static final /* synthetic */ void access$setFieldIndex$p(TextInputItemHolder textInputItemHolder, int i) {
            textInputItemHolder.fieldIndex = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemTextInput memberVerificationItemTextInput = (MemberVerificationItemTextInput) data;
            this.fieldIndex = memberVerificationItemTextInput.getFieldIndex();
            this.binding.f17266b.setText(memberVerificationItemTextInput.getResponse());
            TextInputEditText textInputEditText = this.binding.f17266b;
            String response = memberVerificationItemTextInput.getResponse();
            textInputEditText.setSelection(response != null ? response.length() : 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter(RecyclerView recyclerView, AppFragment appFragment) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        this.fragment = appFragment;
        this.onUpdateRulesApproval = MemberVerificationRulesAdapter5.INSTANCE;
        this.onUserInputDataEntered = MemberVerificationRulesAdapter6.INSTANCE;
    }

    public final AppFragment getFragment() {
        return this.fragment;
    }

    public final Function1<Boolean, Unit> getOnUpdateRulesApproval() {
        return this.onUpdateRulesApproval;
    }

    public final Function2<Integer, Object, Unit> getOnUserInputDataEntered() {
        return this.onUserInputDataEntered;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnUpdateRulesApproval(Function1<? super Boolean, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onUpdateRulesApproval = function1;
    }

    public final void setOnUserInputDataEntered(Function2<? super Integer, Object, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onUserInputDataEntered = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new ItemHolder(this);
            case 1:
                return new TermHeaderItemHolder(this);
            case 2:
                return new ApproveTermsItemHolder(this);
            case 3:
                return new TermItemHolder(this);
            case 4:
                return new TextInputItemHolder(this);
            case 5:
                return new ParagraphItemHolder(this);
            case 6:
                return new MultipleChoiceItemHolder(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
