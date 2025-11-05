package com.discord.widgets.chat.input.models;

import b.d.b.a.a;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.models.MentionInputModel;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: InputSelectionModel.kt */
/* loaded from: classes2.dex */
public abstract class InputSelectionModel {
    private final MentionInputModel inputModel;
    private final IntRange selection;

    /* compiled from: InputSelectionModel.kt */
    public static final /* data */ class CommandInputSelectionModel extends InputSelectionModel {
        private final MentionInputModel.VerifiedCommandInputModel inputModel;
        private final ApplicationCommandOption selectedCommandOption;
        private final IntRange selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommandInputSelectionModel(MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel, IntRange intRange, ApplicationCommandOption applicationCommandOption) {
            super(verifiedCommandInputModel, intRange, null);
            m.checkNotNullParameter(verifiedCommandInputModel, "inputModel");
            m.checkNotNullParameter(intRange, "selection");
            this.inputModel = verifiedCommandInputModel;
            this.selection = intRange;
            this.selectedCommandOption = applicationCommandOption;
        }

        public static /* synthetic */ CommandInputSelectionModel copy$default(CommandInputSelectionModel commandInputSelectionModel, MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel, IntRange intRange, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                verifiedCommandInputModel = commandInputSelectionModel.getInputModel();
            }
            if ((i & 2) != 0) {
                intRange = commandInputSelectionModel.getSelection();
            }
            if ((i & 4) != 0) {
                applicationCommandOption = commandInputSelectionModel.selectedCommandOption;
            }
            return commandInputSelectionModel.copy(verifiedCommandInputModel, intRange, applicationCommandOption);
        }

        public final MentionInputModel.VerifiedCommandInputModel component1() {
            return getInputModel();
        }

        public final IntRange component2() {
            return getSelection();
        }

        /* renamed from: component3, reason: from getter */
        public final ApplicationCommandOption getSelectedCommandOption() {
            return this.selectedCommandOption;
        }

        public final CommandInputSelectionModel copy(MentionInputModel.VerifiedCommandInputModel inputModel, IntRange selection, ApplicationCommandOption selectedCommandOption) {
            m.checkNotNullParameter(inputModel, "inputModel");
            m.checkNotNullParameter(selection, "selection");
            return new CommandInputSelectionModel(inputModel, selection, selectedCommandOption);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommandInputSelectionModel)) {
                return false;
            }
            CommandInputSelectionModel commandInputSelectionModel = (CommandInputSelectionModel) other;
            return m.areEqual(getInputModel(), commandInputSelectionModel.getInputModel()) && m.areEqual(getSelection(), commandInputSelectionModel.getSelection()) && m.areEqual(this.selectedCommandOption, commandInputSelectionModel.selectedCommandOption);
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public /* bridge */ /* synthetic */ MentionInputModel getInputModel() {
            return getInputModel();
        }

        public final ApplicationCommandOption getSelectedCommandOption() {
            return this.selectedCommandOption;
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public IntRange getSelection() {
            return this.selection;
        }

        public int hashCode() {
            MentionInputModel.VerifiedCommandInputModel inputModel = getInputModel();
            int iHashCode = (inputModel != null ? inputModel.hashCode() : 0) * 31;
            IntRange selection = getSelection();
            int iHashCode2 = (iHashCode + (selection != null ? selection.hashCode() : 0)) * 31;
            ApplicationCommandOption applicationCommandOption = this.selectedCommandOption;
            return iHashCode2 + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("CommandInputSelectionModel(inputModel=");
            sbU.append(getInputModel());
            sbU.append(", selection=");
            sbU.append(getSelection());
            sbU.append(", selectedCommandOption=");
            sbU.append(this.selectedCommandOption);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public MentionInputModel.VerifiedCommandInputModel getInputModel() {
            return this.inputModel;
        }
    }

    /* compiled from: InputSelectionModel.kt */
    public static final /* data */ class MessageInputSelectionModel extends InputSelectionModel {
        private final MentionInputModel inputModel;
        private final IntRange selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageInputSelectionModel(MentionInputModel mentionInputModel, IntRange intRange) {
            super(mentionInputModel, intRange, null);
            m.checkNotNullParameter(mentionInputModel, "inputModel");
            m.checkNotNullParameter(intRange, "selection");
            this.inputModel = mentionInputModel;
            this.selection = intRange;
        }

        public static /* synthetic */ MessageInputSelectionModel copy$default(MessageInputSelectionModel messageInputSelectionModel, MentionInputModel mentionInputModel, IntRange intRange, int i, Object obj) {
            if ((i & 1) != 0) {
                mentionInputModel = messageInputSelectionModel.getInputModel();
            }
            if ((i & 2) != 0) {
                intRange = messageInputSelectionModel.getSelection();
            }
            return messageInputSelectionModel.copy(mentionInputModel, intRange);
        }

        public final MentionInputModel component1() {
            return getInputModel();
        }

        public final IntRange component2() {
            return getSelection();
        }

        public final MessageInputSelectionModel copy(MentionInputModel inputModel, IntRange selection) {
            m.checkNotNullParameter(inputModel, "inputModel");
            m.checkNotNullParameter(selection, "selection");
            return new MessageInputSelectionModel(inputModel, selection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageInputSelectionModel)) {
                return false;
            }
            MessageInputSelectionModel messageInputSelectionModel = (MessageInputSelectionModel) other;
            return m.areEqual(getInputModel(), messageInputSelectionModel.getInputModel()) && m.areEqual(getSelection(), messageInputSelectionModel.getSelection());
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public MentionInputModel getInputModel() {
            return this.inputModel;
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public IntRange getSelection() {
            return this.selection;
        }

        public int hashCode() {
            MentionInputModel inputModel = getInputModel();
            int iHashCode = (inputModel != null ? inputModel.hashCode() : 0) * 31;
            IntRange selection = getSelection();
            return iHashCode + (selection != null ? selection.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("MessageInputSelectionModel(inputModel=");
            sbU.append(getInputModel());
            sbU.append(", selection=");
            sbU.append(getSelection());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private InputSelectionModel(MentionInputModel mentionInputModel, IntRange intRange) {
        this.inputModel = mentionInputModel;
        this.selection = intRange;
    }

    public MentionInputModel getInputModel() {
        return this.inputModel;
    }

    public IntRange getSelection() {
        return this.selection;
    }

    public /* synthetic */ InputSelectionModel(MentionInputModel mentionInputModel, IntRange intRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(mentionInputModel, intRange);
    }
}
