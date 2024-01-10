//
//  ContentView.swift
//  FirstSwiftApp
//
//  Created by Yixuan Dai on 10/01/2024.
//

import SwiftUI

enum Emoji: String, CaseIterable {
    case 😅, 😲, 🤡
}

struct ContentView: View {
    @State var selection: Emoji = .😅
    
    var body: some View {
        NavigationView {
            VStack {
                Text(selection.rawValue)
                    .font(.system(size: 120))
                
                Picker("Select Emoji", selection: $selection) {
                    ForEach(Emoji.allCases, id: \.self) {
                        emoji in Text(emoji.rawValue)
                    }
                }
                .pickerStyle(.segmented)
            }
            .padding()
            .navigationTitle("Hello, Swift!")
        }
    }
}

#Preview {
    ContentView()
}
