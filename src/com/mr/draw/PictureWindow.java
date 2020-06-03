package com.mr.draw;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JWindow;

import com.mr.util.BackgroundPanel;

/**
 * ��ʻ�չʾ����
 * 
 * @������λ ����ʡ���տƼ����޹�˾
 * @��˾��ַ www.mingribook.com
 */
public class PictureWindow extends JWindow {
	private JButton changeButton;// ����ͼƬ��ť
	private JButton hiddenButton;// ���ذ�ť
	private BackgroundPanel centerPanel;// չʾͼƬ�Ĵ�����ͼ���
	File list[];// ͼƬ�ļ�����
	int index;// ��ǰѡ�е�ͼƬ����
	DrawPictureFrame frame;// ������

	/**
	 * ���췽��
	 * 
	 * @param frame
	 *            - ������
	 */
	public PictureWindow(DrawPictureFrame frame) {
		this.frame = frame;// ���������ֵ����������
		setSize(400, 460);// ���ô�����
		init();// ��ʼ���������
		addListener();// �������Ӽ���
	}// PictureWindow()����

	/**
	 * �����ʼ������
	 */
	private void init() {
		Container c = getContentPane();// ��ȡ����������
		File dir = new File("src/img/picture");// ������ʻ��ز��ļ��ж���
		list = dir.listFiles();// ��ȡ�ļ�����������ļ�
		// ��ʼ��������壬ʹ��ͼƬ�ļ������һ�ż�ʻ�
		centerPanel = new BackgroundPanel(getListImage());
		c.add(centerPanel, BorderLayout.CENTER);// �������ŵ��������в�

		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);// �����Ҷ����������
		flow.setHgap(20);// ˮƽ���20����
		JPanel southPanel = new JPanel();// �����ϲ����
		southPanel.setLayout(flow);// �ϲ����ʹ�øղŴ����õ�������
		changeButton = new JButton("����ͼƬ");// ʵ����������ͼƬ����ť
		southPanel.add(changeButton);// �ϲ������Ӱ�ť
		hiddenButton = new JButton("����");// ʵ���������ء���ť
		southPanel.add(hiddenButton);// �ϲ������Ӱ�ť
		c.add(southPanel, BorderLayout.SOUTH);// �ϲ����ŵ����������ϲ�λ��
	}// init()����

	/**
	 * ��Ӽ���
	 */
	private void addListener() {
		hiddenButton.addActionListener(new ActionListener() {// ���ذ�ť��Ӷ�������
					public void actionPerformed(ActionEvent e) {// �����ʱ
						setVisible(false);// �����岻�ɼ�
						frame.initShowPicButton();// ���ര�廹ԭ��ʻ���ť���ı�����
					}// actionPerformed();
				});// hiddenButton.addActionListener()����
		changeButton.addActionListener(new ActionListener() {// ����ͼƬ��ť��Ӷ�������
					public void actionPerformed(ActionEvent e) {// �����ʱ
						centerPanel.setImage(getListImage());// ���������������ͼƬ
					}// actionPerformed();
				});// changeButton.addActionListener()����
	}// addListener()

	/**
	 * ��ȡͼƬ�ļ����µ�ͼƬ��ÿ�ε��ô˷����������ò�ͬ���ļ�����
	 * 
	 * @return ����ͼƬ����
	 */
	private Image getListImage() {
		String imgPath = list[index].getAbsolutePath();// ��ȡ��ǰ�����µ�ͼƬ�ļ�·��
		ImageIcon image = new ImageIcon(imgPath);// ��ȡ��ͼƬ�ļ���ͼ�����
		index++;// ������������
		if (index >= list.length) {// ���������������ͼƬ������
			index = 0;// ������������
		}// if����
		return image.getImage();// ���ͼ������ͼƬ����
	}// getListImage()����
}// PictureWindow�����