package com.rehan.androidinterviewquestionsandanswers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

class MyExpandableListAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> questions;
    HashMap<String, List<String>> answers;

    public MyExpandableListAdapter(Context context, List<String> questions, HashMap<String, List<String>> answers) {
        this.context = context;
        this.questions = questions;
        this.answers = answers;
    }

    @Override
    public int getGroupCount() {
        return questions.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return answers.get(questions.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return questions.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return answers.get(questions.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String questions= (String) getGroup(groupPosition);
        if(convertView==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.layout_question,null);
        }

        TextView textView1=(TextView) convertView.findViewById(R.id.textViewQuestion);
        textView1.setText(questions);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String answers= (String) getChild(groupPosition,childPosition);
        if(convertView==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.layout_answer,null);
        }

        TextView textView2=(TextView) convertView.findViewById(R.id.textViewAnswer);
        textView2.setText(answers);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
