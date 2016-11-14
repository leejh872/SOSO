package soso.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForTag extends TagSupport {

	// ���� �ƴ� static�� ����
	// �����ڿ� ���
	int index = 0;

	// �����±� ���� �� ���� ����
	@Override
	public int doStartTag() throws JspException {
		// body���� �����Ҳ��� ������
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {

		if (++index > 5)
			// ���� ��ŵ
			return SKIP_BODY;
		// ���� �ݺ�
		return EVAL_BODY_AGAIN;
	}

	// �� �±� ���� �� ���Ұ���
	@Override
	public int doEndTag() throws JspException {
		// �Ʒ� �±װ��� ������ ����
		return EVAL_PAGE;
	}
}
