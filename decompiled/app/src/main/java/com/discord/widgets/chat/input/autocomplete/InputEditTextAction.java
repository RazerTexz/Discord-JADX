package com.discord.widgets.chat.input.autocomplete;

import android.text.style.CharacterStyle;
import b.d.b.a.a;
import d0.t.h0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: InputEditTextAction.kt */
/* loaded from: classes2.dex */
public abstract class InputEditTextAction {
    private final CharSequence assumedInput;

    /* compiled from: InputEditTextAction.kt */
    public static final /* data */ class ClearSpans extends InputEditTextAction {
        private final CharSequence assumedInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearSpans(CharSequence charSequence) {
            super(charSequence, null);
            m.checkNotNullParameter(charSequence, "assumedInput");
            this.assumedInput = charSequence;
        }

        public static /* synthetic */ ClearSpans copy$default(ClearSpans clearSpans, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = clearSpans.getAssumedInput();
            }
            return clearSpans.copy(charSequence);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final ClearSpans copy(CharSequence assumedInput) {
            m.checkNotNullParameter(assumedInput, "assumedInput");
            return new ClearSpans(assumedInput);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ClearSpans) && m.areEqual(getAssumedInput(), ((ClearSpans) other).getAssumedInput());
            }
            return true;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            if (assumedInput != null) {
                return assumedInput.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("ClearSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: InputEditTextAction.kt */
    public static final /* data */ class InsertText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final IntRange insertRange;
        private final int selectionIndex;
        private final CharSequence toAppend;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsertText(CharSequence charSequence, CharSequence charSequence2, IntRange intRange, int i) {
            super(charSequence, null);
            m.checkNotNullParameter(charSequence, "assumedInput");
            m.checkNotNullParameter(charSequence2, "toAppend");
            m.checkNotNullParameter(intRange, "insertRange");
            this.assumedInput = charSequence;
            this.toAppend = charSequence2;
            this.insertRange = intRange;
            this.selectionIndex = i;
        }

        public static /* synthetic */ InsertText copy$default(InsertText insertText, CharSequence charSequence, CharSequence charSequence2, IntRange intRange, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = insertText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                charSequence2 = insertText.toAppend;
            }
            if ((i2 & 4) != 0) {
                intRange = insertText.insertRange;
            }
            if ((i2 & 8) != 0) {
                i = insertText.selectionIndex;
            }
            return insertText.copy(charSequence, charSequence2, intRange, i);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getToAppend() {
            return this.toAppend;
        }

        /* renamed from: component3, reason: from getter */
        public final IntRange getInsertRange() {
            return this.insertRange;
        }

        /* renamed from: component4, reason: from getter */
        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final InsertText copy(CharSequence assumedInput, CharSequence toAppend, IntRange insertRange, int selectionIndex) {
            m.checkNotNullParameter(assumedInput, "assumedInput");
            m.checkNotNullParameter(toAppend, "toAppend");
            m.checkNotNullParameter(insertRange, "insertRange");
            return new InsertText(assumedInput, toAppend, insertRange, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InsertText)) {
                return false;
            }
            InsertText insertText = (InsertText) other;
            return m.areEqual(getAssumedInput(), insertText.getAssumedInput()) && m.areEqual(this.toAppend, insertText.toAppend) && m.areEqual(this.insertRange, insertText.insertRange) && this.selectionIndex == insertText.selectionIndex;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final IntRange getInsertRange() {
            return this.insertRange;
        }

        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final CharSequence getToAppend() {
            return this.toAppend;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            CharSequence charSequence = this.toAppend;
            int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            IntRange intRange = this.insertRange;
            return ((iHashCode2 + (intRange != null ? intRange.hashCode() : 0)) * 31) + this.selectionIndex;
        }

        public String toString() {
            StringBuilder sbU = a.U("InsertText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", toAppend=");
            sbU.append(this.toAppend);
            sbU.append(", insertRange=");
            sbU.append(this.insertRange);
            sbU.append(", selectionIndex=");
            return a.B(sbU, this.selectionIndex, ")");
        }
    }

    /* compiled from: InputEditTextAction.kt */
    public static final /* data */ class None extends InputEditTextAction {
        private final CharSequence assumedInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public None(CharSequence charSequence) {
            super(charSequence, null);
            m.checkNotNullParameter(charSequence, "assumedInput");
            this.assumedInput = charSequence;
        }

        public static /* synthetic */ None copy$default(None none, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = none.getAssumedInput();
            }
            return none.copy(charSequence);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final None copy(CharSequence assumedInput) {
            m.checkNotNullParameter(assumedInput, "assumedInput");
            return new None(assumedInput);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof None) && m.areEqual(getAssumedInput(), ((None) other).getAssumedInput());
            }
            return true;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            if (assumedInput != null) {
                return assumedInput.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("None(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: InputEditTextAction.kt */
    public static final /* data */ class RemoveText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final IntRange range;
        private final int selectionIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveText(CharSequence charSequence, IntRange intRange, int i) {
            super(charSequence, null);
            m.checkNotNullParameter(charSequence, "assumedInput");
            m.checkNotNullParameter(intRange, "range");
            this.assumedInput = charSequence;
            this.range = intRange;
            this.selectionIndex = i;
        }

        public static /* synthetic */ RemoveText copy$default(RemoveText removeText, CharSequence charSequence, IntRange intRange, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = removeText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                intRange = removeText.range;
            }
            if ((i2 & 4) != 0) {
                i = removeText.selectionIndex;
            }
            return removeText.copy(charSequence, intRange, i);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* renamed from: component2, reason: from getter */
        public final IntRange getRange() {
            return this.range;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final RemoveText copy(CharSequence assumedInput, IntRange range, int selectionIndex) {
            m.checkNotNullParameter(assumedInput, "assumedInput");
            m.checkNotNullParameter(range, "range");
            return new RemoveText(assumedInput, range, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoveText)) {
                return false;
            }
            RemoveText removeText = (RemoveText) other;
            return m.areEqual(getAssumedInput(), removeText.getAssumedInput()) && m.areEqual(this.range, removeText.range) && this.selectionIndex == removeText.selectionIndex;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final IntRange getRange() {
            return this.range;
        }

        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            IntRange intRange = this.range;
            return ((iHashCode + (intRange != null ? intRange.hashCode() : 0)) * 31) + this.selectionIndex;
        }

        public String toString() {
            StringBuilder sbU = a.U("RemoveText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", range=");
            sbU.append(this.range);
            sbU.append(", selectionIndex=");
            return a.B(sbU, this.selectionIndex, ")");
        }
    }

    /* compiled from: InputEditTextAction.kt */
    public static final /* data */ class ReplaceCharacterStyleSpans extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Map<IntRange, List<CharacterStyle>> spans;

        public /* synthetic */ ReplaceCharacterStyleSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? h0.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReplaceCharacterStyleSpans copy$default(ReplaceCharacterStyleSpans replaceCharacterStyleSpans, CharSequence charSequence, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = replaceCharacterStyleSpans.getAssumedInput();
            }
            if ((i & 2) != 0) {
                map = replaceCharacterStyleSpans.spans;
            }
            return replaceCharacterStyleSpans.copy(charSequence, map);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final Map<IntRange, List<CharacterStyle>> component2() {
            return this.spans;
        }

        public final ReplaceCharacterStyleSpans copy(CharSequence assumedInput, Map<IntRange, ? extends List<? extends CharacterStyle>> spans) {
            m.checkNotNullParameter(assumedInput, "assumedInput");
            m.checkNotNullParameter(spans, "spans");
            return new ReplaceCharacterStyleSpans(assumedInput, spans);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplaceCharacterStyleSpans)) {
                return false;
            }
            ReplaceCharacterStyleSpans replaceCharacterStyleSpans = (ReplaceCharacterStyleSpans) other;
            return m.areEqual(getAssumedInput(), replaceCharacterStyleSpans.getAssumedInput()) && m.areEqual(this.spans, replaceCharacterStyleSpans.spans);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Map<IntRange, List<CharacterStyle>> getSpans() {
            return this.spans;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Map<IntRange, List<CharacterStyle>> map = this.spans;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ReplaceCharacterStyleSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", spans=");
            return a.M(sbU, this.spans, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ReplaceCharacterStyleSpans(CharSequence charSequence, Map<IntRange, ? extends List<? extends CharacterStyle>> map) {
            super(charSequence, null);
            m.checkNotNullParameter(charSequence, "assumedInput");
            m.checkNotNullParameter(map, "spans");
            this.assumedInput = charSequence;
            this.spans = map;
        }
    }

    /* compiled from: InputEditTextAction.kt */
    public static final /* data */ class ReplacePillSpans extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Map<IntRange, List<CharacterStyle>> spans;

        public /* synthetic */ ReplacePillSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? h0.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReplacePillSpans copy$default(ReplacePillSpans replacePillSpans, CharSequence charSequence, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = replacePillSpans.getAssumedInput();
            }
            if ((i & 2) != 0) {
                map = replacePillSpans.spans;
            }
            return replacePillSpans.copy(charSequence, map);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final Map<IntRange, List<CharacterStyle>> component2() {
            return this.spans;
        }

        public final ReplacePillSpans copy(CharSequence assumedInput, Map<IntRange, ? extends List<? extends CharacterStyle>> spans) {
            m.checkNotNullParameter(assumedInput, "assumedInput");
            m.checkNotNullParameter(spans, "spans");
            return new ReplacePillSpans(assumedInput, spans);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplacePillSpans)) {
                return false;
            }
            ReplacePillSpans replacePillSpans = (ReplacePillSpans) other;
            return m.areEqual(getAssumedInput(), replacePillSpans.getAssumedInput()) && m.areEqual(this.spans, replacePillSpans.spans);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Map<IntRange, List<CharacterStyle>> getSpans() {
            return this.spans;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Map<IntRange, List<CharacterStyle>> map = this.spans;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ReplacePillSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", spans=");
            return a.M(sbU, this.spans, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ReplacePillSpans(CharSequence charSequence, Map<IntRange, ? extends List<? extends CharacterStyle>> map) {
            super(charSequence, null);
            m.checkNotNullParameter(charSequence, "assumedInput");
            m.checkNotNullParameter(map, "spans");
            this.assumedInput = charSequence;
            this.spans = map;
        }
    }

    /* compiled from: InputEditTextAction.kt */
    public static final /* data */ class ReplaceText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final CharSequence newText;
        private final int selectionIndex;

        public /* synthetic */ ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, charSequence2, (i2 & 4) != 0 ? charSequence2.length() : i);
        }

        public static /* synthetic */ ReplaceText copy$default(ReplaceText replaceText, CharSequence charSequence, CharSequence charSequence2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = replaceText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                charSequence2 = replaceText.newText;
            }
            if ((i2 & 4) != 0) {
                i = replaceText.selectionIndex;
            }
            return replaceText.copy(charSequence, charSequence2, i);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getNewText() {
            return this.newText;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final ReplaceText copy(CharSequence assumedInput, CharSequence newText, int selectionIndex) {
            m.checkNotNullParameter(assumedInput, "assumedInput");
            m.checkNotNullParameter(newText, "newText");
            return new ReplaceText(assumedInput, newText, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplaceText)) {
                return false;
            }
            ReplaceText replaceText = (ReplaceText) other;
            return m.areEqual(getAssumedInput(), replaceText.getAssumedInput()) && m.areEqual(this.newText, replaceText.newText) && this.selectionIndex == replaceText.selectionIndex;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final CharSequence getNewText() {
            return this.newText;
        }

        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            CharSequence charSequence = this.newText;
            return ((iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31) + this.selectionIndex;
        }

        public String toString() {
            StringBuilder sbU = a.U("ReplaceText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", newText=");
            sbU.append(this.newText);
            sbU.append(", selectionIndex=");
            return a.B(sbU, this.selectionIndex, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i) {
            super(charSequence, null);
            m.checkNotNullParameter(charSequence, "assumedInput");
            m.checkNotNullParameter(charSequence2, "newText");
            this.assumedInput = charSequence;
            this.newText = charSequence2;
            this.selectionIndex = i;
        }
    }

    /* compiled from: InputEditTextAction.kt */
    public static final /* data */ class SelectText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final IntRange selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectText(CharSequence charSequence, IntRange intRange) {
            super(charSequence, null);
            m.checkNotNullParameter(charSequence, "assumedInput");
            m.checkNotNullParameter(intRange, "selection");
            this.assumedInput = charSequence;
            this.selection = intRange;
        }

        public static /* synthetic */ SelectText copy$default(SelectText selectText, CharSequence charSequence, IntRange intRange, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = selectText.getAssumedInput();
            }
            if ((i & 2) != 0) {
                intRange = selectText.selection;
            }
            return selectText.copy(charSequence, intRange);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* renamed from: component2, reason: from getter */
        public final IntRange getSelection() {
            return this.selection;
        }

        public final SelectText copy(CharSequence assumedInput, IntRange selection) {
            m.checkNotNullParameter(assumedInput, "assumedInput");
            m.checkNotNullParameter(selection, "selection");
            return new SelectText(assumedInput, selection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectText)) {
                return false;
            }
            SelectText selectText = (SelectText) other;
            return m.areEqual(getAssumedInput(), selectText.getAssumedInput()) && m.areEqual(this.selection, selectText.selection);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final IntRange getSelection() {
            return this.selection;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            IntRange intRange = this.selection;
            return iHashCode + (intRange != null ? intRange.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("SelectText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", selection=");
            sbU.append(this.selection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private InputEditTextAction(CharSequence charSequence) {
        this.assumedInput = charSequence;
    }

    public CharSequence getAssumedInput() {
        return this.assumedInput;
    }

    public /* synthetic */ InputEditTextAction(CharSequence charSequence, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence);
    }
}
